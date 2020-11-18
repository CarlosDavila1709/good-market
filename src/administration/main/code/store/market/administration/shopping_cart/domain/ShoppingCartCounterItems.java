package store.market.administration.shopping_cart.domain;

import store.market.shared.domain.IntValueObject;

public final class ShoppingCartCounterItems extends IntValueObject{

	public ShoppingCartCounterItems(int value) {
		
		super(value);
	}
	public ShoppingCartCounterItems() {
		
		super(null);
	}
	
    public static ShoppingCartCounterItems initialize() {
        return new ShoppingCartCounterItems(0);
    }
    public ShoppingCartCounterItems increment(int value) {
        return new ShoppingCartCounterItems(value() + value);
    }
    public ShoppingCartCounterItems decrement(int value) {
        return new ShoppingCartCounterItems(value() - value);
    }
}
