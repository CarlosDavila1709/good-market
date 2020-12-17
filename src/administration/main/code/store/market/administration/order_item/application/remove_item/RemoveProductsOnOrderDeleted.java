package store.market.administration.order_item.application.remove_item;

import org.springframework.context.event.EventListener;

import store.market.administration.order.domain.OrderId;
import store.market.administration.order_item.domain.ItemId;

import store.market.shared.domain.Service;
import store.market.shared.domain.bus.event.DomainEventSubscriber;
import store.market.shared.domain.orders.DeleteItemToOrderAggregateDomainEvent;

@Service
@DomainEventSubscriber({DeleteItemToOrderAggregateDomainEvent.class})
public final class RemoveProductsOnOrderDeleted {

	private final OrderItemRemoveter removeter;
	
	public RemoveProductsOnOrderDeleted(OrderItemRemoveter removeter) {
		
		this.removeter = removeter;
	}
    @EventListener
    public void on(DeleteItemToOrderAggregateDomainEvent event) {
        
    	OrderId orderId = new OrderId(event.aggregateId());
    	ItemId itemId = new ItemId(event.itemId());
    	
        removeter.remover(orderId,itemId);

    }
}
