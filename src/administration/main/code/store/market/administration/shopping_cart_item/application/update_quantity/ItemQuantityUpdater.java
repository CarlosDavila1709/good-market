package store.market.administration.shopping_cart_item.application.update_quantity;

import store.market.administration.product_catalog.application.ProductCatalogResponse;
import store.market.administration.product_catalog.application.find.FindProductCatalogQuery;
import store.market.administration.shopping_cart_item.domain.CartItem;
import store.market.administration.shopping_cart_item.domain.CartItemId;
import store.market.administration.shopping_cart_item.domain.CartItemNotExist;
import store.market.administration.shopping_cart_item.domain.CartItemProductPrice;
import store.market.administration.shopping_cart_item.domain.CartItemQuantity;
import store.market.administration.shopping_cart_item.domain.ItemCartRepository;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.event.EventBus;
import store.market.shared.domain.bus.query.QueryBus;

@Service
public final class ItemQuantityUpdater {

	private ItemCartRepository repository;
	private final QueryBus queryBus;
    private final EventBus eventBus;
    
	public ItemQuantityUpdater(ItemCartRepository repository,QueryBus queryBus,EventBus eventBus) {
		this.repository = repository;
    	this.queryBus 	= queryBus;
    	this.eventBus 	= eventBus;
	}
	
	public void update( CartItemId id,  CartItemQuantity quantity) {
		
		CartItem cartItem= repository.search(id).orElseThrow(() -> { throw new CartItemNotExist(id); });
		ProductCatalogResponse product = queryBus.ask(new FindProductCatalogQuery(cartItem.productId().value()));

		cartItem.updateQuantity(cartItem.shoppingCartId(),cartItem.productId(),quantity);
		cartItem.updateAmountTotal(new CartItemProductPrice(product.price()), quantity);
		
		repository.save(cartItem);
		
		eventBus.publish(cartItem.pullDomainEvents());
	}
}
