package store.market.administration.shopping_cart_item.application.add_item;

import org.springframework.context.event.EventListener;

import store.market.administration.shopping_cart_item.domain.CartItemProductId;
import store.market.administration.shopping_cart_item.domain.CartItemQuantity;
import store.market.administration.shopping_cart_item.domain.ShoppingCartSessionId;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.event.DomainEventSubscriber;
import store.market.shared.domain.shopping_cart.ProductToShoppingCartAggregateDomainEvent;

@Service
@DomainEventSubscriber({ProductToShoppingCartAggregateDomainEvent.class})
public final class AddItemsOnCartAggregate {

	private final AddItemsOnCart addItemsOnCart;
	
	public AddItemsOnCartAggregate(AddItemsOnCart addItemsOnCart) {
	
		this.addItemsOnCart = addItemsOnCart;
	}
	
    @EventListener
    public void on(ProductToShoppingCartAggregateDomainEvent event) {
    	
    	ShoppingCartSessionId shoppingCartId = new ShoppingCartSessionId(event.aggregateId());
        CartItemProductId productId = new CartItemProductId(event.productId());
        CartItemQuantity quantity = new CartItemQuantity(event.quantity());
        
        addItemsOnCart.add(shoppingCartId, productId,quantity);
    }
}
