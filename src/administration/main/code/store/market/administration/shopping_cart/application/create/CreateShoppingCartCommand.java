package store.market.administration.shopping_cart.application.create;

import store.market.shared.domain.bus.command.Command;

public final class CreateShoppingCartCommand  implements Command {

	private final String id;
	private final String sessionId;
	private final Double amountTotal;
	
	public CreateShoppingCartCommand(String id, String sessionId, Double amountTotal) {
		
		this.id = id;
		this.sessionId = sessionId;
		this.amountTotal = amountTotal;
		
	}
	public String id() {
		return id;
	}
	public String sessionId() {
		return sessionId;
	}
	public Double amountTotal() {
		return amountTotal;
	}
}
