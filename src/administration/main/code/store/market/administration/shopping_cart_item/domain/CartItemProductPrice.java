package store.market.administration.shopping_cart_item.domain;

import store.market.shared.domain.DoubleValueObject;

public final class CartItemProductPrice extends DoubleValueObject{

	public CartItemProductPrice(Double value) {
		super(value);
	}
	public CartItemProductPrice() {
		
		super(null);
	}
}
