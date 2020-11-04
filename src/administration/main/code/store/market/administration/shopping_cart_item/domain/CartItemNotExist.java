package store.market.administration.shopping_cart_item.domain;

import store.market.shared.domain.DomainError;

public final class CartItemNotExist extends DomainError {


	public CartItemNotExist(CartItemId id) {
		 
		super("item_not_exist", String.format("The item <%s> doesn't exist", id.value()));
	}
	
}
