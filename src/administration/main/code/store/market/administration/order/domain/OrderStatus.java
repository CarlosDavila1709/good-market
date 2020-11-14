package store.market.administration.order.domain;

import store.market.shared.domain.StringValueObject;

public final class OrderStatus extends StringValueObject{

	public OrderStatus(String value) {
		super(value);
	}
	public OrderStatus() {
		super("");
	}
}
