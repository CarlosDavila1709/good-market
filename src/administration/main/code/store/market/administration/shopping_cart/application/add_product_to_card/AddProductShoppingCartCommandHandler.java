package store.market.administration.shopping_cart.application.add_product_to_card;

import store.market.administration.grocery.domain.BackofficeGroceryId;
import store.market.administration.product_catalog.domain.ProductCatalogId;
import store.market.administration.shopping_cart.domain.ShoppingCartQuantity;
import store.market.administration.shopping_cart.domain.ShoppingCartSessionId;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.command.CommandHandler;

@Service
public final class AddProductShoppingCartCommandHandler implements CommandHandler<AddProductShoppingCartCommand>{

	private final AddProductShoppingCart aggregator;
	
	public AddProductShoppingCartCommandHandler(AddProductShoppingCart aggregator) {
		
		this.aggregator = aggregator;
	}
    @Override
    public void handle(AddProductShoppingCartCommand command) {

        ShoppingCartSessionId 	sessionId  		= new ShoppingCartSessionId(command.sessionId());
        ProductCatalogId  		productId 		= new ProductCatalogId(command.productId());
        ShoppingCartQuantity 	quantity 		= new ShoppingCartQuantity(command.quantity());
        BackofficeGroceryId     groceryId		= new BackofficeGroceryId(command.groceryId());
        aggregator.add(sessionId,groceryId,productId,quantity);
    }
}
