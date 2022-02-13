package store.market.backoffice.auth.application.login_by_google;


import store.market.backoffice.auth.application.TokenResponse;
import store.market.backoffice.auth.domain.LoginNotExist;
import store.market.backoffice.grocery.domain.GroceryId;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.query.QueryHandler;

@Service
public class LoginGoogleQueryHandler implements QueryHandler<LoginGoogleQuery, TokenResponse>{

	private LoginGoogle login;
	
	public LoginGoogleQueryHandler(LoginGoogle login) {
		this.login = login;
	}
	
    @Override
    public TokenResponse handle(LoginGoogleQuery query) throws LoginNotExist {
    	GroceryId idGrocery = new GroceryId(query.uidGrocery());
    	return login.loguer(query.token(), idGrocery);
    	
    }
}
