package store.market.administration.order.application.add_product_to_order;

import store.market.shared.domain.bus.command.Command;

public final class AddProductOrderCommand implements Command{

	private final String orderId;
	private final String productId;
	private final int quantity;
	
	public AddProductOrderCommand(String orderId,String productId, int quantity) {

		this.orderId = orderId;
		this.productId = productId;
		this.quantity  = quantity;
	}
	
	public String orderId() {
		return orderId;
	}
	public String productId() {
		return productId;
	}
	public int quantity() {
		return quantity;
	}
}
