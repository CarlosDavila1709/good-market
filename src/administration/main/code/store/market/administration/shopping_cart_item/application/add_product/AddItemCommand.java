package store.market.administration.shopping_cart_item.application.add_product;

import store.market.shared.domain.bus.command.Command;

public final class AddItemCommand implements Command{

	private String sessionId;
	private String productId;
	private Double price;
	private Integer quantity;
	
	public AddItemCommand(String sessionId,String productId,Double price,Integer quantity) {

		this.sessionId = sessionId;
		this.productId = productId;
		this.price = price;
		this.quantity = quantity;
	}

	public String sessionId() {
		return sessionId;
	}
	public String productId() {
		return productId;
	}
	public Double price() {
		return price;
	}
	public Integer quantity() {
		return quantity;
	}
	
}
