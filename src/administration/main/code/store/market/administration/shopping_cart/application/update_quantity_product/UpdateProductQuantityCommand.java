package store.market.administration.shopping_cart.application.update_quantity_product;

import store.market.shared.domain.bus.command.Command;

public class UpdateProductQuantityCommand implements Command{

	private final String sessionId;
	private final String productId;
	private Integer quantity;
	
	public UpdateProductQuantityCommand(String sessionId,String productId,Integer quantity) {
		this.productId = productId;
		this.sessionId = sessionId;
		this.quantity  = quantity;
	}
	
	public String productId() {
        return productId;
    }
	public String sessionId() {
		return sessionId;
	}
	public Integer quantity() {
		return quantity;
	}
}
