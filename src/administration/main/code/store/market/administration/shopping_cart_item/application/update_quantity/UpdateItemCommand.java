package store.market.administration.shopping_cart_item.application.update_quantity;

import store.market.shared.domain.bus.command.Command;

public final class UpdateItemCommand implements Command{

	private final String id;
	
	private final Integer quantity;
	
	public UpdateItemCommand(String id, Integer quantity) {
		
		this.id = id;
		this.quantity = quantity;
	}
	
	public String id() {
		return id;
	}
	
	public Integer quantity() {
		
		return quantity;
	}
}
