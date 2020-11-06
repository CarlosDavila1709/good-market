package store.market.administration.shopping_cart.domain;

import store.market.shared.domain.IntValueObject;

public final class ShoppingCartQuantity extends IntValueObject{

	public ShoppingCartQuantity(Integer value) {
		super(value);
		
	}
	public ShoppingCartQuantity() {
		super(null);
		
	}
	public static ShoppingCartQuantity initialize() {
		
		return new ShoppingCartQuantity(0);
		
	}
}
