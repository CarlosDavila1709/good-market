package store.market.backoffice.auth.application.create;

import store.market.backoffice.auth.domain.AuthUser;
import store.market.backoffice.auth.domain.AuthUserAlreadyExists;
import store.market.backoffice.auth.domain.AuthUserEmail;

import store.market.backoffice.auth.domain.AuthUserId;
import store.market.backoffice.auth.domain.AuthUserPassword;
import store.market.backoffice.auth.domain.AuthUserRepository;
import store.market.backoffice.auth.domain.OAuthCompany;
import store.market.backoffice.grocery.domain.GroceryId;
import store.market.shared.domain.Service;

@Service
public final class UserCreator {

	private final AuthUserRepository repository;
	private final static String OAUTH_LOCAL = "local"; 
	private final static boolean OAUTH_EXTERNAL = false;
	
	
	public UserCreator(AuthUserRepository repository) {

		this.repository = repository;
	}
	
	public void create(AuthUserId id, AuthUserEmail email, AuthUserPassword password, GroceryId idGrocery) {

		insureEmailExist( email );
		AuthUser authUser = AuthUser.create(id, email, password, idGrocery,new OAuthCompany(OAUTH_LOCAL),OAUTH_EXTERNAL);
        repository.save(authUser);
  
    }
	
	private void insureEmailExist(AuthUserEmail email) {
        
		boolean existsEmail = repository.search(email).isPresent();
		
		if(existsEmail) {
			throw new AuthUserAlreadyExists(email);
		}
	}
}
