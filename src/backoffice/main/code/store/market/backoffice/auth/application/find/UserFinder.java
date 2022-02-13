package store.market.backoffice.auth.application.find;

import store.market.backoffice.auth.application.UserResponse;

import store.market.backoffice.auth.domain.AuthUserEmail;
import store.market.backoffice.auth.domain.AuthUserNotExist;
import store.market.backoffice.auth.domain.AuthUserRepository;
import store.market.shared.domain.Service;

@Service
public final class UserFinder {

	private AuthUserRepository repository;
	
	public UserFinder(AuthUserRepository repository) {
		
		this.repository = repository;
	}
	
	public UserResponse find(AuthUserEmail email) {
		
		UserResponse response =  repository.search(email)
                .map(UserResponse::fromAggregate)
                .orElseThrow(() -> new AuthUserNotExist(email));

		return response;
	}
}
