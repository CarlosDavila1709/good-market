package store.market.administration.product_catalog.application.search_by_categorie;

import store.market.administration.product_catalog.application.ProductCatalogResponse;
import store.market.administration.product_catalog.application.ProductsCatalogResponse;
import store.market.administration.product_catalog.domain.ProductCatalogRepository;
import store.market.shared.domain.Service;
import store.market.shared.domain.criteria.Criteria;
import store.market.shared.domain.criteria.Filter;
import store.market.shared.domain.criteria.Filters;
import store.market.shared.domain.criteria.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategorieProductCatalogSearcher {

	private final ProductCatalogRepository repository;
	
	public CategorieProductCatalogSearcher(ProductCatalogRepository repository) {
		
		this.repository = repository;
		
	}
	
	public ProductsCatalogResponse search(String categorieId) {
		Filter filter = Filter.create("categorieId", "=", categorieId);
		List<Filter> filtersList = new ArrayList<Filter>();
		filtersList.add(filter);
		Filters filters = new Filters(filtersList);
		
		Criteria criteria = new Criteria(
				filters,
	            Order.none(),
	            Optional.empty(),
	            Optional.empty()
	        );
        return new ProductsCatalogResponse(
                repository.matching(criteria).stream().map(ProductCatalogResponse::fromAggregate).collect(Collectors.toList())
            );
	}
}
