package store.market.administration.product_catalog.domain;

import store.market.shared.domain.DomainError;

public final class ProductCatalogNotExist extends DomainError{

	public ProductCatalogNotExist(ProductCatalogId id) {
		super("product_catalog_not_exist", String.format("The product catalog <%s> doesn't exist", id.value()));
	}
}
