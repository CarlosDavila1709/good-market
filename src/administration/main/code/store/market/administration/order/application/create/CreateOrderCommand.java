package store.market.administration.order.application.create;

import store.market.shared.domain.bus.command.Command;

public final class CreateOrderCommand implements Command{

	private String id;
	private String sessionId;
	private String customerId;
	
	public CreateOrderCommand(String id, String sessionId,String customerId) {
		
		this.id = id;
		this.sessionId = sessionId;
		this.customerId = customerId;
	}
	
	public String id() {
		return id;
	}
	public String sessionId() {
		return sessionId;
	}
	public String customerId() {
		return customerId;
	}
}
