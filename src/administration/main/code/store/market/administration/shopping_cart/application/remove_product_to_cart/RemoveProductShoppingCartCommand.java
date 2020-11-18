package store.market.administration.shopping_cart.application.remove_product_to_cart;

import store.market.shared.domain.bus.command.Command;

public class RemoveProductShoppingCartCommand implements Command{

	private final String sessionId;
	private final String productId;
	
	public RemoveProductShoppingCartCommand(String sessionId,String productId) {
		this.productId = productId;
		this.sessionId = sessionId;
	}
	
	public String productId() {
        return productId;
    }
	public String sessionId() {
		return sessionId;
	}
	
}
