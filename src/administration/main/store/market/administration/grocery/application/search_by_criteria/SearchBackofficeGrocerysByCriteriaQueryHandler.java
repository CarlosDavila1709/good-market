package store.market.administration.grocery.application.search_by_criteria;

import store.market.administration.grocery.application.BackofficeGrocerysResponse;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.query.QueryHandler;
import store.market.shared.domain.criteria.Filters;
import store.market.shared.domain.criteria.Order;

@Service
public final class SearchBackofficeGrocerysByCriteriaQueryHandler implements QueryHandler<SearchBackofficeGrocerysByCriteriaQuery, BackofficeGrocerysResponse>{

	
    private final BackofficeGrocerysByCriteriaSearcher searcher;

    public SearchBackofficeGrocerysByCriteriaQueryHandler(BackofficeGrocerysByCriteriaSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public BackofficeGrocerysResponse handle(SearchBackofficeGrocerysByCriteriaQuery query) {
        Filters filters = Filters.fromValues(query.filters());
        Order   order   = Order.fromValues(query.orderBy(), query.orderType());

        return searcher.search(filters, order, query.limit(), query.offset());
    }
}
