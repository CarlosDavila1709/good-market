package store.market.administration.order_status.application;

import store.market.administration.order_status.domain.OrderStatus;
import store.market.shared.domain.bus.query.Response;

public final class StatusOrderResponse implements Response {

	private String codigo;

	private String description;

	public StatusOrderResponse(String codigo, String description) {
		this.codigo = codigo;
		this.description = description;
	}

	public static StatusOrderResponse fromAggregate(OrderStatus orderStatus) {

		return new StatusOrderResponse(orderStatus.codigo(), orderStatus.description());
	}
	public String codigo() {
		return codigo;
	}
	public String description() {
		return description;
	}
}
