package store.market.backoffice.auth.application;

import store.market.backoffice.auth.domain.AuthUser;
import store.market.shared.domain.bus.query.Response;

public class UserResponse implements Response{

	private final String id;
	
	private final String email;
	
	private final String token;
	
	public UserResponse(String id, String email, String token) {
		
		this.id = id;
		this.email = email;
		this.token = token;
	}
	
	public static UserResponse fromAggregate(AuthUser user) {
		
		return new UserResponse(user.id().value(),user.email().value()," ");
	}
	
	public String id() {
		return id;
	}
	
	public String email() {
		return email;
	}
	
	public String token() {
		return token;
	}
}
