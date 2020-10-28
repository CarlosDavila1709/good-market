package store.market.administration.product.domain;

import store.market.shared.domain.DoubleValueObject;

public final class ProductPrice extends DoubleValueObject{

	public ProductPrice(Double value) {
		super(value);
	}
	public ProductPrice() {
		super(null);
	}
}
