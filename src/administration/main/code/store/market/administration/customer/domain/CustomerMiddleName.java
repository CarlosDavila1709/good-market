package store.market.administration.customer.domain;

import store.market.shared.domain.StringValueObject;

public final class CustomerMiddleName extends StringValueObject{

	public CustomerMiddleName(String value) {
		super(value);
	}
	
	public CustomerMiddleName() {
		super("");
	}
}
