package store.market.administration.order_item.domain;

import store.market.shared.domain.StringValueObject;

public final class ItemProductName extends StringValueObject{

	public ItemProductName(String value) {
		super(value);
	}
	public ItemProductName() {
		super("");
	}
}
