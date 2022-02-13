package store.market.shared.infrastructure.auth_token;

public interface Token {

	public String generarToken(String secret, String uid);
	public void validarToken(String token, String secret) ;
}
