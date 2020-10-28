package store.market.backoffice.grocery.application.search_by_criteria;

import store.market.backoffice.grocery.application.GrocerysResponse;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.query.QueryHandler;

import store.market.shared.domain.criteria.Filters;
import store.market.shared.domain.criteria.Order;

@Service
public final class SearchGrocerysByCriteriaQueryHandler implements QueryHandler<SearchGrocerysByCriteriaQuery, GrocerysResponse> {

	private final GrocerysByCriteriaSearcher searcher;
	
    public SearchGrocerysByCriteriaQueryHandler(GrocerysByCriteriaSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public GrocerysResponse handle(SearchGrocerysByCriteriaQuery query) {
        Filters filters = Filters.fromValues(query.filters());
        Order   order   = Order.fromValues(query.orderBy(), query.orderType());

        return searcher.search(filters, order, query.limit(), query.offset());
    }
}
