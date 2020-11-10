package store.market.administration.customer.domain;

import store.market.shared.domain.StringValueObject;

public final class CustomerFirstName extends StringValueObject {

	public CustomerFirstName(String value) {
		super(value);
	}
	public CustomerFirstName() {
		super("");
	}
}
