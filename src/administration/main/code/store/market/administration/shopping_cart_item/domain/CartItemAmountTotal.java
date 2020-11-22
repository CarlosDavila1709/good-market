package store.market.administration.shopping_cart_item.domain;

import store.market.shared.domain.DoubleValueObject;

public final class CartItemAmountTotal extends DoubleValueObject{

	public CartItemAmountTotal(Double value) {
		super(value);
		// TODO Auto-generated constructor stub
	}

	public CartItemAmountTotal() {
		super(null);
		// TODO Auto-generated constructor stub
	}
    public CartItemAmountTotal increment(Double value) {
        
    	return new CartItemAmountTotal(this.value() + value);
    	
    }
    public CartItemAmountTotal decrement(Double value) {
        
    	return new CartItemAmountTotal(this.value() - value);
    	
    }
    public static CartItemAmountTotal initialize() {
        return new CartItemAmountTotal(0.00);
    }
}
