package store.market.backoffice.auth.domain;

import store.market.shared.domain.DomainError;

public class TokenInvalidException extends DomainError{

	public TokenInvalidException(String token) {
		super("token_invalid", String.format("The token <%s> invalid", token));
	}
}
