package store.market.administration.order_item.application.create;

import org.springframework.context.event.EventListener;

import store.market.administration.order.domain.OrderId;
import store.market.administration.shopping_cart.domain.ShoppingCartId;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.event.DomainEventSubscriber;
import store.market.shared.domain.orders.OrderCreatedDomainEvent;


@Service
@DomainEventSubscriber({OrderCreatedDomainEvent.class})
public final class ItemCreateOnOrderAggregate {

	private ItemCreate itemCreate;
	
	public ItemCreateOnOrderAggregate(ItemCreate itemCreate) {
		this.itemCreate = itemCreate;
	}
    @EventListener
    public void on(OrderCreatedDomainEvent event) {
    
    	ShoppingCartId cartId = new ShoppingCartId(event.cartId());
    	OrderId orderId   = new OrderId(event.aggregateId());
    	itemCreate.create(orderId, cartId);
    }
}
