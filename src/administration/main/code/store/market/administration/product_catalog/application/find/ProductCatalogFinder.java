package store.market.administration.product_catalog.application.find;

import store.market.administration.product_catalog.application.ProductCatalogResponse;
import store.market.administration.product_catalog.domain.ProductCatalogId;
import store.market.administration.product_catalog.domain.ProductCatalogNotExist;
import store.market.administration.product_catalog.domain.ProductCatalogRepository;
import store.market.shared.domain.Service;

@Service
public final class ProductCatalogFinder {

	private final ProductCatalogRepository repository;
	
	public ProductCatalogFinder(ProductCatalogRepository repository) {
		
		this.repository = repository;
	}
    public ProductCatalogResponse find(ProductCatalogId id) throws ProductCatalogNotExist {
        return repository.search(id)
                         .map(ProductCatalogResponse::fromAggregate)
                         .orElseThrow(() -> new ProductCatalogNotExist(id));
    }
	
}
