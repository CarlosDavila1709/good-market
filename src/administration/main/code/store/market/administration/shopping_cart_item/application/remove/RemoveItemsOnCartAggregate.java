package store.market.administration.shopping_cart_item.application.remove;

import org.springframework.context.event.EventListener;

import store.market.administration.shopping_cart_item.domain.CartItemProductId;
import store.market.administration.shopping_cart_item.domain.ShoppingCartSessionId;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.event.DomainEventSubscriber;
import store.market.shared.domain.shopping_cart.DeleteProductToShoppingCartAggregateDomainEvent;


@Service
@DomainEventSubscriber({DeleteProductToShoppingCartAggregateDomainEvent.class})
public final class RemoveItemsOnCartAggregate {

	private final ItemRemoveter removeter;
	
	public RemoveItemsOnCartAggregate(ItemRemoveter removeter) {
		
		this.removeter =  removeter;
	}
	
    @EventListener
    public void on(DeleteProductToShoppingCartAggregateDomainEvent event) {
    	ShoppingCartSessionId sessionId = new ShoppingCartSessionId(event.sessionId());
        CartItemProductId productId 		 = new CartItemProductId(event.productId());
        
        removeter.removerv2(sessionId,productId);
    }
}
