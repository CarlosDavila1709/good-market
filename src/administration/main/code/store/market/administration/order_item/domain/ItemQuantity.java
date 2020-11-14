package store.market.administration.order_item.domain;

import store.market.shared.domain.IntValueObject;

public final class ItemQuantity extends IntValueObject{

	public ItemQuantity(Integer value) {
		super(value);
	}
	public ItemQuantity() {
		super(null);
	}
}
