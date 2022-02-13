package store.market.backoffice.auth.domain;

import store.market.shared.domain.DomainError;

public final class EmailFormatIncorrectException extends DomainError{
	
	public EmailFormatIncorrectException(AuthUserEmail email) {
	        
		 super("auth_user_email_incorrect", String.format("The email <%s> incorrect", email.value()));
	}
}
