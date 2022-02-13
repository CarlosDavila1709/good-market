package store.market.backoffice.auth.domain;

import store.market.shared.domain.DomainError;

public final class AuthUserNotExist extends DomainError{
	
	  public AuthUserNotExist(AuthUserEmail email) {
	        super("auth_user_not_exist", String.format("The user <%s> doesn't exist", email.value()));
	  }
}
