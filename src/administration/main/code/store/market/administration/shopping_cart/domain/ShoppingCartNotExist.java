package store.market.administration.shopping_cart.domain;

import store.market.shared.domain.DomainError;

public final class ShoppingCartNotExist extends DomainError{

	public ShoppingCartNotExist(ShoppingCartId id) {
		 
		super("shoppingcart_not_exist", String.format("The shoppingcart <%s> doesn't exist", id.value()));
	}
	
}
