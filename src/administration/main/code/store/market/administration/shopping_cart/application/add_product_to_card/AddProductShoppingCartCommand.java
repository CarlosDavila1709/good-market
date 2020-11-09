package store.market.administration.shopping_cart.application.add_product_to_card;

import store.market.shared.domain.bus.command.Command;

public final class AddProductShoppingCartCommand  implements Command {

	private final String sessionId;
	private final String groceryId;
	private final String productId;
	private final int quantity;
	
	public AddProductShoppingCartCommand( String sessionId, String groceryId,String productId, int quantity) {
		

		this.sessionId = sessionId;
		this.groceryId = groceryId;
		this.productId = productId;
		this.quantity  = quantity;
	}

	public String sessionId() {
		return sessionId;
	}
	public String productId() {
		return productId;
	}
	public int quantity() {
		return quantity;
	}
	public String groceryId() {
		return groceryId;
	}
}
