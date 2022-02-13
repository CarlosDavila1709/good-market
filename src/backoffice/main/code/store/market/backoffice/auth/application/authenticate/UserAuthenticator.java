package store.market.backoffice.auth.application.authenticate;

import java.util.Optional;

import store.market.backoffice.auth.domain.AuthUserPassword;
import store.market.backoffice.auth.domain.AuthUser;
import store.market.backoffice.auth.domain.AuthUserEmail;
import store.market.backoffice.auth.domain.AuthUserRepository;
import store.market.backoffice.auth.domain.InvalidAuthCredentials;
import store.market.backoffice.auth.domain.InvalidAuthUsername;
import store.market.shared.domain.Service;

@Service
public class UserAuthenticator {

    private final AuthUserRepository repository;
	
    public UserAuthenticator(AuthUserRepository repository) {
    	this.repository = repository;
    }
    
    public void authenticate(AuthUserEmail email, AuthUserPassword password) {
        Optional<AuthUser> auth = repository.search(email);

        ensureUserExist(auth, email);
        ensureCredentialsAreValid(auth.get(), password);
    }
    
    private void ensureUserExist(Optional<AuthUser> auth, AuthUserEmail email) {
        if (!auth.isPresent()) {
            throw new InvalidAuthUsername(email);
        }
    }
    
    private void ensureCredentialsAreValid(AuthUser auth, AuthUserPassword password) {
        if (!auth.passwordMatches(password)) {
            throw new InvalidAuthCredentials(auth.email());
        }
    }
}
