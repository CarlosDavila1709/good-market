package store.market.administration.order.application.search_by_criteria;

import store.market.administration.order.application.OrdersResponse;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.query.QueryHandler;
import store.market.shared.domain.criteria.Filters;
import store.market.shared.domain.criteria.Order;

@Service
public final  class SearchOrdersByCriteriaQueryHandler implements QueryHandler<SearchOrdersByCriteriaQuery, OrdersResponse>{

	private OrdersByCriteriaSearcher searcher;
	
	public SearchOrdersByCriteriaQueryHandler(OrdersByCriteriaSearcher searcher) {
		this.searcher = searcher;
	}
	@Override
	public OrdersResponse handle(SearchOrdersByCriteriaQuery query) {
       
		Filters filters = Filters.fromValues(query.filters());
        Order   order   = Order.fromValues(query.orderBy(), query.orderType());
        return searcher.search(filters, order, query.limit(), query.offset());
	}

}
