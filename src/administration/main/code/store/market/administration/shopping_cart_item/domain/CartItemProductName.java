package store.market.administration.shopping_cart_item.domain;

import store.market.shared.domain.StringValueObject;

public final class CartItemProductName extends StringValueObject{

	public CartItemProductName(String value) {
		
		super(value);
	}
	public CartItemProductName() {
		super("");
	}
}
