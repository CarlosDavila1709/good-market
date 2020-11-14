package store.market.administration.order.application.create;


import store.market.administration.order.domain.OrderId;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateOrderCommandHandler implements CommandHandler<CreateOrderCommand>{

	private final OrderCreator creator;
	
	public CreateOrderCommandHandler(OrderCreator creator) {
		this.creator = creator;
	}
	
	@Override
	public void handle(CreateOrderCommand command) {
		OrderId id = new OrderId(command.id());
		
		creator.create(id, command.customerId(), command.sessionId());
		
	}

}
