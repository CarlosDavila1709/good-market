package store.market.backoffice.auth.application;

import java.util.List;

import store.market.shared.domain.bus.query.Response;

public class UsersResponse implements Response {

	private final List<UserResponse> users;
	
	public UsersResponse(List<UserResponse> users) {
		
		this.users = users;
	}
	
	public List<UserResponse> users() {
	    return this.users;
	}
}
