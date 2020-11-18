package store.market.administration.shopping_cart.application.update_quantity_product;

import store.market.administration.product_catalog.domain.ProductCatalogId;
import store.market.administration.shopping_cart.domain.ShoppingCartQuantity;
import store.market.administration.shopping_cart.domain.ShoppingCartSessionId;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.command.CommandHandler;

@Service
public final class UpdateProductQuantityCommandHandler implements CommandHandler<UpdateProductQuantityCommand>{

	private final ProductQuantityUpdater updater;
	
	public UpdateProductQuantityCommandHandler(ProductQuantityUpdater updater) {
		
		this.updater  = updater;

	}

	@Override
	public void handle(UpdateProductQuantityCommand command) {
		
		ShoppingCartSessionId 	sessionId = new ShoppingCartSessionId(command.sessionId());
		ProductCatalogId 		productId = new ProductCatalogId(command.productId());
		ShoppingCartQuantity 	quantity  = new ShoppingCartQuantity(command.quantity());
		
		updater.update(sessionId, productId, quantity);
		
	}
	
	
}
