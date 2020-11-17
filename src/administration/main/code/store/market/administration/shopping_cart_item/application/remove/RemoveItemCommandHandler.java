package store.market.administration.shopping_cart_item.application.remove;

import store.market.administration.shopping_cart_item.domain.CartItemId;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.command.CommandHandler;


@Service
public final class RemoveItemCommandHandler implements CommandHandler<RemoveItemCommand> {

	private final ItemRemoveter removeter;
	
	
	public RemoveItemCommandHandler(ItemRemoveter removeter) {
		
		this.removeter = removeter;
	}
	
	@Override
	public void handle(RemoveItemCommand command) {
		CartItemId id = new CartItemId(command.id());
		removeter.remover(id);
	}

}
