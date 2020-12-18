package store.market.administration.order_item.domain;

import store.market.shared.domain.IntValueObject;

public final class ItemQuantity extends IntValueObject{

	public ItemQuantity(Integer value) {
		super(value);
	}
	public ItemQuantity() {
		super(null);
	}
    public static ItemQuantity initialize() {
        return new ItemQuantity(0);
    }
    public ItemQuantity increment(int value) {
        return new ItemQuantity(value() + value);
    }
    public ItemQuantity decrement(int value) {
        return new ItemQuantity(value() - value);
    }
}
