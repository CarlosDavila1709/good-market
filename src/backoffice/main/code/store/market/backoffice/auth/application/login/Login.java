package store.market.backoffice.auth.application.login;

import java.util.Optional;

import store.market.backoffice.auth.application.TokenResponse;
import store.market.backoffice.auth.application.token_generate.GenerateToken;
import store.market.backoffice.auth.domain.AuthUser;
import store.market.backoffice.auth.domain.AuthUserEmail;
import store.market.backoffice.auth.domain.AuthUserNotExist;
import store.market.backoffice.auth.domain.AuthUserPassword;
import store.market.backoffice.auth.domain.AuthUserRepository;
import store.market.backoffice.auth.domain.PasswordIncorrect;
import store.market.shared.domain.Service;

@Service
public final class Login  {

	private final AuthUserRepository repository;
	private final GenerateToken token;
	
	public Login(AuthUserRepository repository, GenerateToken token) {
		
		this.repository = repository;
		this.token	 	= token;
	}
	
	public TokenResponse loguer(AuthUserEmail email, AuthUserPassword pass) {
		
		Optional<AuthUser> auth = repository.search(email);
		
        ensureUserExist(auth, email);
        ensureCredentialsAreValid(auth.get(), pass);
		
		String tokenizer = token.generar(email);
		
		return new TokenResponse(tokenizer);
	}
    private void ensureUserExist(Optional<AuthUser> auth, AuthUserEmail email) {
        if (!auth.isPresent()) {
            throw new AuthUserNotExist(email);
        }
    }
    
    private void ensureCredentialsAreValid(AuthUser auth, AuthUserPassword password) {
        if (!auth.passwordMatches(password)) {
            throw new PasswordIncorrect(auth.email());
        }
    }
}
