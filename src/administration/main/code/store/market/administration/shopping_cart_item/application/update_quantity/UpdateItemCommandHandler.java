package store.market.administration.shopping_cart_item.application.update_quantity;

import store.market.administration.shopping_cart_item.domain.CartItemId;
import store.market.administration.shopping_cart_item.domain.CartItemQuantity;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.command.CommandHandler;

@Service
public final class UpdateItemCommandHandler implements CommandHandler<UpdateItemCommand>{


	private ItemQuantityUpdater updater;
	
	public UpdateItemCommandHandler(ItemQuantityUpdater updater) {
		
		this.updater = updater;
	}
	
	@Override
	public void handle(UpdateItemCommand command) {
		 
		CartItemId 		 id 	  = new CartItemId(command.id());
		CartItemQuantity quantity = new CartItemQuantity(command.quantity());
		
		updater.update(id, quantity);
	}

}
