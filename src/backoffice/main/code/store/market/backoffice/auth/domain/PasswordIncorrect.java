package store.market.backoffice.auth.domain;

import store.market.shared.domain.DomainError;

public class PasswordIncorrect  extends DomainError{

	 public PasswordIncorrect(AuthUserEmail email) {
	        
		 super("password_incorrect", String.format("The user <%s> password incorrect, min 6 caracters", email.value()));
	  }
}
