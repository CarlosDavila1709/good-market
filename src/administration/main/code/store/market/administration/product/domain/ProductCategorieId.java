package store.market.administration.product.domain;

import store.market.shared.domain.Identifier;
import store.market.shared.domain.StringValueObject;

public final class ProductCategorieId extends Identifier{

	public ProductCategorieId(String value) {
		
		super(value);
	}
	
	public ProductCategorieId() {
		//super(null);
	}
}
