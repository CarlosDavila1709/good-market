package store.market.backoffice.auth.application.login;

import store.market.backoffice.auth.application.TokenResponse;
import store.market.backoffice.auth.domain.AuthUserEmail;
import store.market.backoffice.auth.domain.AuthUserPassword;
import store.market.backoffice.auth.domain.LoginNotExist;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.query.QueryHandler;

@Service
public class LoginQueryHandler  implements QueryHandler<LoginQuery, TokenResponse>{

    private final Login login;

    public LoginQueryHandler(Login login) {
        this.login = login;
    }

    @Override
    public TokenResponse handle(LoginQuery query) throws LoginNotExist {
        
    	return login.loguer(new AuthUserEmail( query.email() ), new AuthUserPassword( query.password() ));
    	
    }
}
