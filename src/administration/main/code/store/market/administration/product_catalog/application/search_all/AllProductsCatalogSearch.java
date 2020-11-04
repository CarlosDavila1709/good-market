package store.market.administration.product_catalog.application.search_all;

import java.util.stream.Collectors;

import store.market.administration.product_catalog.application.ProductCatalogResponse;
import store.market.administration.product_catalog.application.ProductsCatalogResponse;
import store.market.administration.product_catalog.domain.ProductCatalogRepository;
import store.market.shared.domain.Service;

@Service
public final class AllProductsCatalogSearch {

	private final ProductCatalogRepository repository;
	
	public AllProductsCatalogSearch(ProductCatalogRepository repository) {
		
		this.repository = repository;
	}
	
	public ProductsCatalogResponse search() {
		
		return new ProductsCatalogResponse(
				repository.searchAll().stream().map(ProductCatalogResponse::fromAggregate).collect(Collectors.toList())
		);
	} 
}
