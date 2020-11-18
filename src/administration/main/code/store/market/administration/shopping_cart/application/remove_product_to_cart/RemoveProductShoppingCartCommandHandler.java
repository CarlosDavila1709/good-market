package store.market.administration.shopping_cart.application.remove_product_to_cart;

import store.market.administration.product_catalog.domain.ProductCatalogId;
import store.market.administration.shopping_cart.domain.ShoppingCartSessionId;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.command.CommandHandler;

@Service
public final class RemoveProductShoppingCartCommandHandler implements CommandHandler<RemoveProductShoppingCartCommand> {

	private final RemoveProductShoppingCart remoter;
	
	public RemoveProductShoppingCartCommandHandler(RemoveProductShoppingCart remoter){
		
		this.remoter = remoter;
	}

	@Override
	public void handle(RemoveProductShoppingCartCommand command) {
		
		ShoppingCartSessionId sessionId = new ShoppingCartSessionId(command.sessionId());
		ProductCatalogId productId = new ProductCatalogId(command.productId());
		
		remoter.remove(sessionId, productId);
	}
	
	
}
