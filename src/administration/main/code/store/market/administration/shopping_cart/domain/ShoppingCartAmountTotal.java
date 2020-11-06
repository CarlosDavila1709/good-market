package store.market.administration.shopping_cart.domain;

import store.market.shared.domain.DoubleValueObject;

public final class ShoppingCartAmountTotal extends DoubleValueObject{

	public ShoppingCartAmountTotal(Double value) {
		super(value);
		
	}
	public ShoppingCartAmountTotal() {
		super(null);
		
	}
	
    public static ShoppingCartAmountTotal initialize() {
        
    	return new ShoppingCartAmountTotal(0.00);
    }
    
    public ShoppingCartAmountTotal increment(Double value) {
        
    	return new ShoppingCartAmountTotal(this.value() + value);
    	
    }
    public ShoppingCartAmountTotal subtract(Double value) {
        
    	return new ShoppingCartAmountTotal(this.value() - value);
    	
    }
}
