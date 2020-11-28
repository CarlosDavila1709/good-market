package store.market.administration.order_item.application.search_by_order;

import store.market.administration.order.domain.OrderId;
import store.market.administration.order_item.application.OrderItemsResponse;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.query.QueryHandler;

@Service
public final class SearchItemsByOrderQueryHandler implements QueryHandler<SearchItemsByOrderQuery, OrderItemsResponse>{

	private final OrderItemsByOrderSearcher searcher;
	
	public SearchItemsByOrderQueryHandler(OrderItemsByOrderSearcher searcher) {
		
		this.searcher = searcher;
	}
	@Override
	public OrderItemsResponse handle(SearchItemsByOrderQuery query) {
		OrderId orderId = new OrderId(query.orderId());
		return searcher.search(orderId);
	}

	
}
