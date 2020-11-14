package store.market.administration.order.domain;

import store.market.shared.domain.DoubleValueObject;

public final class OrderAmountTotal extends DoubleValueObject{

	public OrderAmountTotal(Double value) {
		super(value);
	}
	public OrderAmountTotal() {
		super(null);
	}
}
