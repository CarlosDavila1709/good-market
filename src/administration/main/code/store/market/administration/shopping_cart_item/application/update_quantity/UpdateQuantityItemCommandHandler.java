package store.market.administration.shopping_cart_item.application.update_quantity;

import store.market.administration.shopping_cart_item.domain.CartItemId;
import store.market.administration.shopping_cart_item.domain.CartItemQuantity;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.command.CommandHandler;

@Service
public final class UpdateQuantityItemCommandHandler implements CommandHandler<UpdateQuantityItemCommand>{

	private ItemQuantityUpdater updater;
	
	public UpdateQuantityItemCommandHandler(ItemQuantityUpdater updater) {
		
		this.updater = updater;
	}
	
	@Override
	public void handle(UpdateQuantityItemCommand command) {
		 
		CartItemId 		 id 	  = new CartItemId(command.id());		
		CartItemQuantity quantity = new CartItemQuantity(command.quantity());
		
		updater.update(id, quantity);
	}

}
