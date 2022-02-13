package store.market.backoffice.auth.application.login;

import store.market.shared.domain.bus.query.Query;

public class LoginQuery  implements Query{

    private final String email;
    
	private final String password;
	
	public LoginQuery(String email,String password) {
		
		this.email = email;
		this.password = password;
		
	}
	
	public String email() {
		return email;
	}
	public String password() {
		return password;
	}
}
