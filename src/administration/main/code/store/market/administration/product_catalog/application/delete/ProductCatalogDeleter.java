package store.market.administration.product_catalog.application.delete;

import store.market.administration.product_catalog.domain.ProductCatalog;
import store.market.administration.product_catalog.domain.ProductCatalogId;
import store.market.administration.product_catalog.domain.ProductCatalogRepository;
import store.market.shared.domain.Service;

@Service
public final class ProductCatalogDeleter {

	private final ProductCatalogRepository repository;
	
	public ProductCatalogDeleter(ProductCatalogRepository repository) {
		this.repository = repository;
	}
	
	public void delete(ProductCatalogId id) {
	
		ProductCatalog product = repository.search(id).orElseGet(()->null);
		
		if(product != null) 
			this.repository.delete(product);

	}
}
