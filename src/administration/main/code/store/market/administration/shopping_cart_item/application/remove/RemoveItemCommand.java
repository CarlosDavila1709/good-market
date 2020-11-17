package store.market.administration.shopping_cart_item.application.remove;

import store.market.shared.domain.bus.command.Command;

public class RemoveItemCommand implements Command{

	private final String id;
	
	public RemoveItemCommand(String id) {
		this.id = id;
	}
	
	public String id() {
        return id;
    }
}
