package store.market.administration.product_catalog.application;

import java.util.List;

import store.market.shared.domain.bus.query.Response;

public class ProductsCatalogResponse implements Response{

	private final List<ProductCatalogResponse> products;
	
	public ProductsCatalogResponse(List<ProductCatalogResponse> products) {
		
		this.products = products;
	}
	
	public List<ProductCatalogResponse> products() {
	    return products;
	}
}
