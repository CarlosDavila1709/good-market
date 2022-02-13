package store.market.backoffice.auth.application.authenticate_by_token;


import store.market.backoffice.auth.infrastructure.auth.SecurityToken;
import store.market.shared.domain.Service;


@Service
public final class TokenAuthenticator {
	
	private final SecurityToken token;
	
	public TokenAuthenticator(SecurityToken token) {
		this.token = token;
	}
	
	public void authenticate(String token) {

		this.token.validarToken(token);


	}
}
