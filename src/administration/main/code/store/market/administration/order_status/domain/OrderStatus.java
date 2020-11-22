package store.market.administration.order_status.domain;

public final class OrderStatus {

	private String codigo;
	
	private String description;

	public OrderStatus(String codigo,String description) {

		this.codigo  	 = codigo;
		this.description = description;
	}

	public static OrderStatus create(String codigo,String description) {

		OrderStatus status = new OrderStatus(codigo,description);

		return status;
	}

	public String description() {
		return description;
	}

	public String codigo() {
		return codigo;
	}

}
