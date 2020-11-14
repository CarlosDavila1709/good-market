package store.market.administration.shopping_cart.domain;

import store.market.shared.domain.StringValueObject;

public final class ShoppingCartStatus extends StringValueObject {
	
	public ShoppingCartStatus(String value) {
		super(value);
	}
	public ShoppingCartStatus() {
		super("");
	}

}
