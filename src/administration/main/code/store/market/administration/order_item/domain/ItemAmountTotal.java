package store.market.administration.order_item.domain;

import store.market.shared.domain.DoubleValueObject;

public final class ItemAmountTotal extends DoubleValueObject{

	public ItemAmountTotal(Double value) {
		super(value);
	}
	public ItemAmountTotal() {
		super(null);
	}
    public ItemAmountTotal increment(Double value) {
        
    	return new ItemAmountTotal(this.value() + value);
    	
    }
    public ItemAmountTotal subtract(Double value) {
        
    	return new ItemAmountTotal(this.value() - value);
    	
    }
}
