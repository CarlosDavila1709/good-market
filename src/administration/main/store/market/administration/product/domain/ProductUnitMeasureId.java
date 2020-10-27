package store.market.administration.product.domain;

import store.market.shared.domain.Identifier;
import store.market.shared.domain.StringValueObject;

public final class ProductUnitMeasureId extends StringValueObject{

	public ProductUnitMeasureId(String value) {
		super(value);
	}
	
	public ProductUnitMeasureId() {
		super(null);
	}
}
