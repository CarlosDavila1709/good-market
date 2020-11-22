package store.market.administration.shopping_cart.application.remove_product_to_cart;

import org.springframework.context.event.EventListener;

import store.market.administration.product_catalog.domain.ProductCatalogId;
import store.market.administration.shopping_cart.domain.ShoppingCartId;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.event.DomainEventSubscriber;
import store.market.shared.domain.shopping_cart_item.DeleteItemToShoppingCartAggregateDomainEvent;

@Service
@DomainEventSubscriber({DeleteItemToShoppingCartAggregateDomainEvent.class})
public final class RemoveProductsOnCartItemDeleted {

	private final RemoveProductShoppingCart removeter;
	
	public RemoveProductsOnCartItemDeleted(RemoveProductShoppingCart removeter) {
		this.removeter = removeter;
	}
    @EventListener
    public void on(DeleteItemToShoppingCartAggregateDomainEvent event) {
        
    	ShoppingCartId shoppingCartId = new ShoppingCartId(event.shoppingCartId());
        ProductCatalogId productId = new ProductCatalogId(event.itemProductId());
        
        removeter.remove(shoppingCartId,productId,event.aggregateId());

    }
}
