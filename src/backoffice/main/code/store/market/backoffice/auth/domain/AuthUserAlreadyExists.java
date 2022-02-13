package store.market.backoffice.auth.domain;

import store.market.shared.domain.DomainError;

public final class AuthUserAlreadyExists extends DomainError{

	  public AuthUserAlreadyExists(AuthUserEmail email) {
	        super("auth_user_already_exist", String.format("The user <%s> already exists", email.value()));
	  }
}
