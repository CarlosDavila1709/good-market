package store.market.administration.order.application.remove_product_to_order;

import store.market.shared.domain.bus.command.Command;

public class RemoveItemToOrderCommand implements Command{

	private final String orderId;
	private final String orderItemId;
	
	public RemoveItemToOrderCommand(String orderId,String orderItemId) {
		this.orderId = orderId;
		this.orderItemId = orderItemId;
	}
	
	public String orderId() {
        return orderId;
    }
	public String orderItemId() {
		return orderItemId;
	}
}
