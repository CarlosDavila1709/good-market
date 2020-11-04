package store.market.administration.shopping_cart.domain;

import store.market.shared.domain.StringValueObject;

public class ShoppingCartSessionId extends StringValueObject{

	public ShoppingCartSessionId(String value) {
		super(value);
		
	}
	public ShoppingCartSessionId() {
		super("");
		
	}
}
