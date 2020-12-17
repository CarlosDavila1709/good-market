package store.market.administration.order.domain;

import store.market.shared.domain.IntValueObject;

public final class OrderCounterItems extends IntValueObject{

	public OrderCounterItems(Integer value) {
		super(value);
	}
	public OrderCounterItems() {
		super(null);
	}
	
    public static OrderCounterItems initialize() {
        return new OrderCounterItems(0);
    }
    public OrderCounterItems increment(int value) {
        return new OrderCounterItems(value() + value);
    }
    public OrderCounterItems decrement(int value) {
        return new OrderCounterItems(value() - value);
    }
}
