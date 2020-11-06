package store.market.administration.shopping_cart_item.domain;

import store.market.shared.domain.IntValueObject;

public class CartItemQuantity extends IntValueObject{

	public CartItemQuantity(Integer value) {
		super(value);

	}

	public CartItemQuantity() {
		super(null);
		
	}
	public static CartItemQuantity initialize() {
		
		return new CartItemQuantity(0);
		
	}
	
    public CartItemQuantity increment(CartItemQuantity cartItemQuantity) {
        return new CartItemQuantity(value() + cartItemQuantity.value());
    }
}
