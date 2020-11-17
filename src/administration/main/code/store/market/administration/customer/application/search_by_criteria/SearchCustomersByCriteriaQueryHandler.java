package store.market.administration.customer.application.search_by_criteria;

import store.market.administration.customer.application.CustomersResponse;
import store.market.administration.grocery.application.BackofficeGrocerysResponse;
import store.market.administration.grocery.application.search_by_criteria.BackofficeGrocerysByCriteriaSearcher;
import store.market.administration.grocery.application.search_by_criteria.SearchBackofficeGrocerysByCriteriaQuery;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.query.QueryHandler;
import store.market.shared.domain.criteria.Filters;
import store.market.shared.domain.criteria.Order;

@Service
public final class SearchCustomersByCriteriaQueryHandler implements QueryHandler<SearchCustomersByCriteriaQuery, CustomersResponse>{

    private final CustomersByCriteriaSearcher searcher;

    public SearchCustomersByCriteriaQueryHandler(CustomersByCriteriaSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public CustomersResponse handle(SearchCustomersByCriteriaQuery query) {
        Filters filters = Filters.fromValues(query.filters());
        Order   order   = Order.fromValues(query.orderBy(), query.orderType());

        return searcher.search(filters, order, query.limit(), query.offset());
    }
}
