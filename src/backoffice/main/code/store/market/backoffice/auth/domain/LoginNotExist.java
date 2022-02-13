package store.market.backoffice.auth.domain;

import store.market.shared.domain.DomainError;

public class LoginNotExist extends DomainError{

	 public LoginNotExist(AuthUserEmail email) {
	        
		 super("auth_user_not_exist", String.format("The user <%s> doesn't exist", email.value()));
	  }

}
