package store.market.backoffice.auth.application.login_by_google;

import store.market.shared.domain.bus.query.Query;

public class LoginGoogleQuery implements Query{

	private final String token;
	private final String uidGrocery;
	
	public LoginGoogleQuery(String token,String uidGrocery) {
		this.token 		= token;
		this.uidGrocery = uidGrocery;
	}
	
	public String token() {
		return token;
	}
	
	public String uidGrocery() {
		return uidGrocery;
	}
}
