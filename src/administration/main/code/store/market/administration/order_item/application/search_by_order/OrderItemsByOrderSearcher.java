package store.market.administration.order_item.application.search_by_order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import store.market.administration.order.domain.OrderId;
import store.market.administration.order_item.application.OrderItemResponse;
import store.market.administration.order_item.application.OrderItemsResponse;
import store.market.administration.order_item.domain.ItemRepository;

import store.market.shared.domain.Service;
import store.market.shared.domain.criteria.Criteria;
import store.market.shared.domain.criteria.Filter;
import store.market.shared.domain.criteria.Filters;
import store.market.shared.domain.criteria.Order;

@Service
public final class OrderItemsByOrderSearcher {

	private final ItemRepository repository;
	
	public OrderItemsByOrderSearcher(ItemRepository repository) {
		this.repository = repository;
	}
	
	public OrderItemsResponse search(OrderId orderId) {
		Filter filter = Filter.create("orderId", "=", orderId.value());
		List<Filter> filtersList = new ArrayList<Filter>();
		filtersList.add(filter);
		Filters filters = new Filters(filtersList);
		
		Criteria criteria = new Criteria(
				filters,
	            Order.none(),
	            Optional.empty(),
	            Optional.empty()
	        );
        return new OrderItemsResponse(
                repository.matching(criteria).stream().map(OrderItemResponse::fromAggregate).collect(Collectors.toList())
            );
	}
}
