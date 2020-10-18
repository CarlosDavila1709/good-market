package store.market.backoffice.grocery.domain;

import store.market.shared.domain.StringValueObject;

public class GroceryAddress  extends StringValueObject {

	public GroceryAddress(String value) {
		super(value);
	}
	public GroceryAddress() {
		super("");
	}
	
}
