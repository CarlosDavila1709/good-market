package store.market.administration.product_catalog.application.search_by_criteria;

import java.util.Optional;
import java.util.stream.Collectors;

import store.market.administration.product_catalog.application.ProductCatalogResponse;
import store.market.administration.product_catalog.application.ProductsCatalogResponse;
import store.market.administration.product_catalog.domain.ProductCatalogRepository;
import store.market.shared.domain.Service;
import store.market.shared.domain.criteria.Criteria;
import store.market.shared.domain.criteria.Filters;
import store.market.shared.domain.criteria.Order;

@Service
public class ProductsCatalogByCriteriaSearcher {

	private ProductCatalogRepository repository;
	
	public ProductsCatalogByCriteriaSearcher(ProductCatalogRepository repository) {
		
		this.repository = repository;
	}
	
	public ProductsCatalogResponse search(
		       Filters filters,
		        Order order,
		        Optional<Integer> limit,
		        Optional<Integer> offset) {
		
		Criteria criteria = new Criteria(filters, order, limit, offset);
		
        return new ProductsCatalogResponse(
                repository.matching(criteria)
                          .stream()
                          .map(ProductCatalogResponse::fromAggregate)
                          .collect(Collectors.toList())
            );
	}
}
