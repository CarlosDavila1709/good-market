package store.market.administration.shopping_cart.application.CartStatusProcessor;

import org.springframework.context.event.EventListener;

import store.market.administration.shopping_cart.domain.ShoppingCartId;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.event.DomainEventSubscriber;
import store.market.shared.domain.orders.OrderCreatedDomainEvent;

@Service
@DomainEventSubscriber({OrderCreatedDomainEvent.class})
public final class CartSatusIndictedOnOrderAggregate {

	private CartStatusProcessor cartStatusProcessor;
	
	public CartSatusIndictedOnOrderAggregate(CartStatusProcessor cartStatusProcessor) {
		
		this.cartStatusProcessor = cartStatusProcessor;
	}
	
    @EventListener
    public void on(OrderCreatedDomainEvent event) {
    	
    	ShoppingCartId id = new ShoppingCartId(event.cartId());
    	
    	cartStatusProcessor.process(id);
    }
}
