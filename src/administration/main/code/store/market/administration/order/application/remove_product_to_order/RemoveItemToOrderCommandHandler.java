package store.market.administration.order.application.remove_product_to_order;

import store.market.administration.order.domain.OrderId;
import store.market.administration.order_item.domain.ItemId;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.command.CommandHandler;

@Service
public final class RemoveItemToOrderCommandHandler implements CommandHandler<RemoveItemToOrderCommand> {

	private final RemoveProductsOrder removeter;
	
	
	public RemoveItemToOrderCommandHandler(RemoveProductsOrder removeter) {
		
		this.removeter = removeter;
	}
	
	@Override
	public void handle(RemoveItemToOrderCommand command) {
		
		OrderId orderId = new OrderId(command.orderId());
		ItemId itemId = new ItemId(command.orderItemId());
		
		removeter.remover(orderId, itemId);
	}
}
