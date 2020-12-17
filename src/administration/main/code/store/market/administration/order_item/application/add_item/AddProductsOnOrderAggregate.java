package store.market.administration.order_item.application.add_item;

import org.springframework.context.event.EventListener;

import store.market.administration.order.domain.OrderId;
import store.market.administration.order_item.domain.ItemQuantity;
import store.market.administration.product_catalog.domain.ProductCatalogId;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.event.DomainEventSubscriber;
import store.market.shared.domain.orders.OrderItemsAggregatedDomainEvent;

@Service
@DomainEventSubscriber({ OrderItemsAggregatedDomainEvent.class })
public final class AddProductsOnOrderAggregate {

	private final AddProductsOnOrder aggregated;

	public AddProductsOnOrderAggregate(AddProductsOnOrder aggregated) {

		this.aggregated = aggregated;
	}

	@EventListener
	public void on(OrderItemsAggregatedDomainEvent event) {

		OrderId orderId 					= new OrderId(event.aggregateId());
		ProductCatalogId productCatalogId	= new ProductCatalogId(event.productId());
		ItemQuantity itemQuantity			= new ItemQuantity(event.quantity());
		
		aggregated.add(orderId, itemQuantity , productCatalogId);
		
	}
}
