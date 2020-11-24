package store.market.administration.order.application.update_status_order;

import store.market.administration.order.domain.Order;
import store.market.administration.order.domain.OrderId;
import store.market.administration.order.domain.OrderNotExist;
import store.market.administration.order.domain.OrderRepository;
import store.market.administration.order.domain.OrderStatus;
import store.market.administration.order_status.application.StatusOrderResponse;
import store.market.administration.order_status.application.find.FindOrderStatusQuery;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.query.QueryBus;

@Service
public final class OrderUpdateStatusUpdater {

	private final OrderRepository repository;
	private final QueryBus 		   queryBus;
	
	public OrderUpdateStatusUpdater(OrderRepository repository,QueryBus queryBus) {
		
		this.repository = repository;
		this.queryBus   = queryBus;
		
	}
	
	public void update(OrderId id, OrderStatus status) {
		Order orde = repository.search(id).orElseThrow(()-> new OrderNotExist(id));
		StatusOrderResponse statusOrder = queryBus.ask(new FindOrderStatusQuery(status.value()));
		
		orde.updateStatus(status);
		orde.updateDescriptionStatus(statusOrder.description());
		
		repository.save(orde);
	}
}
