package store.market.administration.order.domain;

import store.market.shared.domain.IntValueObject;

public final class OrderCounterItems extends IntValueObject{

	public OrderCounterItems(Integer value) {
		super(value);
	}
	public OrderCounterItems() {
		super(null);
	}
}
