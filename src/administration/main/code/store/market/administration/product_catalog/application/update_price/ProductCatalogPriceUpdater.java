package store.market.administration.product_catalog.application.update_price;

import store.market.administration.product_catalog.domain.ProductCatalog;
import store.market.administration.product_catalog.domain.ProductCatalogId;
import store.market.administration.product_catalog.domain.ProductCatalogNotExist;
import store.market.administration.product_catalog.domain.ProductCatalogRepository;
import store.market.shared.domain.Service;

@Service
public final class ProductCatalogPriceUpdater {

	private ProductCatalogRepository repository;
	
	public ProductCatalogPriceUpdater(ProductCatalogRepository repository) {
		
		this.repository = repository;
	}
	
	public void update(ProductCatalogId id, Double newPrice) {
		
		ProductCatalog product = repository.search(id).orElseThrow(()->{ throw new ProductCatalogNotExist(id);});
		
		product.updatePrice(newPrice);
		
		repository.save(product);
		
	}
}
