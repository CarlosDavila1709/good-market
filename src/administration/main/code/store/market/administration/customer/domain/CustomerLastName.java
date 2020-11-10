package store.market.administration.customer.domain;

import store.market.shared.domain.StringValueObject;

public final class CustomerLastName extends StringValueObject {

	public CustomerLastName(String value) {
		super(value);
	}
	public CustomerLastName() {
		super("");
	}
}
