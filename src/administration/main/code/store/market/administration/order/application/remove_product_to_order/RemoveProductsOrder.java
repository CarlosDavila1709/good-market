package store.market.administration.order.application.remove_product_to_order;

import store.market.administration.order.domain.Order;
import store.market.administration.order.domain.OrderId;
import store.market.administration.order.domain.OrderNotExist;
import store.market.administration.order.domain.OrderRepository;
import store.market.administration.order_item.application.OrderItemResponse;
import store.market.administration.order_item.application.find.FindOrderItemQuery;
import store.market.administration.order_item.domain.ItemId;
import store.market.administration.product_catalog.domain.ProductCatalogId;

import store.market.shared.domain.Service;
import store.market.shared.domain.bus.event.EventBus;
import store.market.shared.domain.bus.query.QueryBus;

@Service
public final class RemoveProductsOrder {

	private final OrderRepository repository;
	private final QueryBus queryBus;
    private final EventBus eventBus;
    
	public RemoveProductsOrder(OrderRepository repository,QueryBus queryBus,EventBus eventBus) {
		
		this.repository = repository;
		this.queryBus   = queryBus;
		this.eventBus   = eventBus;
	}
	
	public void remover(OrderId orderId, ItemId itemId) {
		
		Order order = repository.search(orderId).orElseThrow(()-> new OrderNotExist(orderId));
		OrderItemResponse orderItem = queryBus.ask(new FindOrderItemQuery(itemId.value()));
		
		order.removeProduct(new ProductCatalogId(orderItem.productId()));
		order.subtractAmountTotal(orderItem.amountTotal());
		order.prepareElimination(orderId.value(), itemId.value());
		
		repository.save(order);
		eventBus.publish(order.pullDomainEvents());
	}
	
}
