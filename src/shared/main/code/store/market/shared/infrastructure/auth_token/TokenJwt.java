package store.market.shared.infrastructure.auth_token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import store.market.shared.domain.Service;

@Service
public final class TokenJwt implements Token{
	
	public String generarToken(String secret, String uid) {
		
		String token = "";
		try {
		    Algorithm algorithm = Algorithm.HMAC256(secret);
		    token = JWT.create()
		        .withIssuer("auth0")
		        .withClaim("uid", uid)
		        .sign(algorithm);
		} catch (JWTCreationException exception){
		    //Invalid Signing configuration / Couldn't convert Claims.
		}
		
		return token;
	}
	
	public void validarToken(String token, String secret) throws JWTVerificationException{
		//String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXUyJ9.eyJpc3MiOiJhdXRoMCJ9.AbIJTDMFc7yUa5MhvcP03nJPyCPzZtQcGEp-zWfOkEE";
		try {
		    Algorithm algorithm = Algorithm.HMAC256(secret);
		    JWTVerifier verifier = JWT.require(algorithm)
		        .withIssuer("auth0")
		        .build(); //Reusable verifier instance
		    DecodedJWT jwt = verifier.verify(token);
		    String resuktado = jwt.getClaim("uid").asString();
		    System.out.printf("resuktado: "+resuktado);
		} catch (JWTVerificationException exception){
		    System.out.printf(exception.getMessage());
		    throw exception;
		}
		
	}
}
