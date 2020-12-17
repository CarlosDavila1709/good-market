package store.market.administration.order.domain;

import store.market.shared.domain.DoubleValueObject;

public final class OrderAmountTotal extends DoubleValueObject{

	public OrderAmountTotal(Double value) {
		super(value);
	}
	public OrderAmountTotal() {
		super(null);
	}
    public OrderAmountTotal increment(Double value) {
        
    	return new OrderAmountTotal(this.value() + value);
    	
    }
    public OrderAmountTotal subtract(Double value) {
        
    	return new OrderAmountTotal(this.value() - value);
    	
    }
}
