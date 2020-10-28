package store.market.administration.shopping_cart.domain;

import store.market.shared.domain.DoubleValueObject;

public final class CardAmountTotal extends DoubleValueObject{

	public CardAmountTotal(Double value) {
		super(value);
		
	}
	public CardAmountTotal() {
		super(null);
		
	}
	
    public CardAmountTotal increment(Double value) {
        
    	return new CardAmountTotal(this.value() + value);
    	
    }
    public CardAmountTotal subtract(Double value) {
        
    	return new CardAmountTotal(this.value() - value);
    	
    }
}
