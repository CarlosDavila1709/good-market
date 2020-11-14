package store.market.administration.order_item.domain;

import store.market.shared.domain.DoubleValueObject;

public final class ItemProductPrice extends DoubleValueObject{

	public ItemProductPrice(Double value) {
		super(value);
	}
	public ItemProductPrice() {
		super(null);
	}
}
