package store.market.administration.product.domain;

import store.market.shared.domain.StringValueObject;

public final class ProductName extends StringValueObject{

	public ProductName(String value) {
		super(value);
	}
	public ProductName() {
		super("");
	}
}
