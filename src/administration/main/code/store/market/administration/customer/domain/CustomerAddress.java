package store.market.administration.customer.domain;

import store.market.shared.domain.StringValueObject;

public final class CustomerAddress extends StringValueObject{

	public CustomerAddress(String value) {
		super(value);
	}
	public CustomerAddress() {
		super("");
	}
}
