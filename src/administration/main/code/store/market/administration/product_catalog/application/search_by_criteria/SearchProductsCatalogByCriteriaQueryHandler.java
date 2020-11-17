package store.market.administration.product_catalog.application.search_by_criteria;

import store.market.administration.product_catalog.application.ProductsCatalogResponse;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.query.QueryHandler;
import store.market.shared.domain.criteria.Filters;
import store.market.shared.domain.criteria.Order;

@Service
public class SearchProductsCatalogByCriteriaQueryHandler implements QueryHandler<SearchProductsCatalogByCriteriaQuery, ProductsCatalogResponse>{

	private ProductsCatalogByCriteriaSearcher searcher;
	
	public SearchProductsCatalogByCriteriaQueryHandler(ProductsCatalogByCriteriaSearcher searcher) {
		this.searcher = searcher;
	}
    @Override
    public ProductsCatalogResponse handle(SearchProductsCatalogByCriteriaQuery query) {
        Filters filters = Filters.fromValues(query.filters());
        Order   order   = Order.fromValues(query.orderBy(), query.orderType());

        return searcher.search(filters, order, query.limit(), query.offset());
    }
}
