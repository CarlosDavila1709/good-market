package store.market.administration.product.application.update_price;

import store.market.shared.domain.bus.command.Command;

public class UpdateProductPriceCommand implements Command{

	private String id;
	private Double price;
	
	public UpdateProductPriceCommand(Double price,String id) {
		this.price = price;
		this.id = id;
	}
	
	public Double price() {
        return price;
    }
	public String id() {
		return id;
	}
}
