package store.market.administration.shopping_cart.domain;

import store.market.shared.domain.DomainError;

public final class CartStatusSessionIndicted  extends DomainError{

	public CartStatusSessionIndicted(ShoppingCartSessionId id) {
		
		super("session_not_exist", String.format("The session <%s> it's already processed", id.value()));
		
	}

}
