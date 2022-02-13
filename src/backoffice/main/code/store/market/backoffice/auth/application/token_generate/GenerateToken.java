package store.market.backoffice.auth.application.token_generate;

import java.util.Optional;

import store.market.backoffice.auth.domain.AuthUser;
import store.market.backoffice.auth.domain.AuthUserEmail;
import store.market.backoffice.auth.domain.AuthUserRepository;
import store.market.backoffice.auth.infrastructure.auth.SecurityToken;
import store.market.shared.domain.Service;

@Service
public final class GenerateToken {

	private final AuthUserRepository repository;
	
	private final SecurityToken token;
	
	public GenerateToken(SecurityToken token,AuthUserRepository repository) {
		
		this.token 		= token;
		this.repository = repository;
	}
	
	public String generar(AuthUserEmail email) {
		
		Optional<AuthUser> user = repository.search(email);

			
		return token.generarToken(user.get().id().value());

	}
}
