package store.market.administration.shopping_cart.application.update_quantity_product;

import org.springframework.context.event.EventListener;

import store.market.administration.product_catalog.domain.ProductCatalogId;
import store.market.administration.shopping_cart.domain.ShoppingCartId;
import store.market.administration.shopping_cart.domain.ShoppingCartQuantity;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.event.DomainEventSubscriber;
import store.market.shared.domain.shopping_cart_item.UpdateQuantityItemToShoppingCartAggregateDomainEvent;

@Service
@DomainEventSubscriber({UpdateQuantityItemToShoppingCartAggregateDomainEvent.class})
public class UpdateTotalItemsAndAmountsOnUpdateQuantityItemAggregate {


	private UpdateAmountAndTotalsUpdater updater;
	
	public UpdateTotalItemsAndAmountsOnUpdateQuantityItemAggregate(UpdateAmountAndTotalsUpdater updater) {
	
		this.updater = updater;
	}
	
	
	@EventListener
    public void on(UpdateQuantityItemToShoppingCartAggregateDomainEvent event) {

		ShoppingCartId cartId = new ShoppingCartId(event.shoppingCartId());
		ProductCatalogId productId = new ProductCatalogId(event.productId());
		ShoppingCartQuantity quantity = new ShoppingCartQuantity(event.quantity());
		
		updater.update(cartId, productId,quantity);

	}
}
