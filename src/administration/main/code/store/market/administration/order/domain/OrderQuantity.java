package store.market.administration.order.domain;

import store.market.shared.domain.IntValueObject;

public final class OrderQuantity extends IntValueObject{

	public OrderQuantity(Integer value) {
		super(value);
		
	}
	public OrderQuantity() {
		super(null);
		
	}
	public static OrderQuantity initialize() {
		
		return new OrderQuantity(0);
		
	}
}
