package store.market.administration.order.application.update_status_order;

import store.market.administration.order.domain.OrderId;
import store.market.administration.order.domain.OrderStatus;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.command.CommandHandler;

@Service
public final class UpdateStatusOrderCommandHandler implements CommandHandler<UpdateStatusOrderCommand>{

	private OrderUpdateStatusUpdater updater;
	
	public UpdateStatusOrderCommandHandler(OrderUpdateStatusUpdater updater) {
		this.updater = updater;
	}
	
	@Override
	public void handle(UpdateStatusOrderCommand command) {
		OrderId id = new OrderId(command.id());
		OrderStatus status = new OrderStatus(command.codigoStatus()); 
		
		updater.update(id, status);
	
	}

}
