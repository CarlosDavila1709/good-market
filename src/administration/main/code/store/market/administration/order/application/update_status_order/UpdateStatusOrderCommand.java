package store.market.administration.order.application.update_status_order;

import store.market.shared.domain.bus.command.Command;

public final class UpdateStatusOrderCommand implements Command{

	private String id;
	private String codigoStatus;
	
	public UpdateStatusOrderCommand(String id,String codigoStatus) {
		
		this.id = id;
		this.codigoStatus = codigoStatus;
	}
	
	public String id() {
		return id;
	}
	public String codigoStatus() {
		return codigoStatus;
	}
}
