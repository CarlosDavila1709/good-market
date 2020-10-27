package store.market.administration.shopping_cart_item.domain;

import store.market.shared.domain.StringValueObject;

public final class CartProductName extends StringValueObject{

	public CartProductName(String value) {
		
		super(value);
	}
	public CartProductName() {
		super("");
	}
}
