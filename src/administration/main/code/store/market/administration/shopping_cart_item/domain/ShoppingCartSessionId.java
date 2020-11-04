package store.market.administration.shopping_cart_item.domain;

import store.market.shared.domain.StringValueObject;

public final class ShoppingCartSessionId extends StringValueObject{

	public ShoppingCartSessionId(String value) {
		super(value);
	}
	public ShoppingCartSessionId() {
		super("");
	}
}
