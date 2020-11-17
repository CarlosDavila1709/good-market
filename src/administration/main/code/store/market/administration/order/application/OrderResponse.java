package store.market.administration.order.application;

import store.market.administration.order.domain.Order;
import store.market.shared.domain.bus.query.Response;

public final class OrderResponse implements Response{

	private String id;
	private String groceryId;
	private String customerId;
	private Double amountTotal;
	private Integer totalItems;
	private String dateCreation;

	public OrderResponse(String id,String groceryId,String customerId,Double amountTotal,Integer totalItems,String dateCreation) {
		this.id = id;
		this.groceryId = groceryId;
		this.customerId = customerId;
		this.amountTotal = amountTotal;
		this.totalItems = totalItems;
		this.dateCreation = dateCreation;
	}
    public static OrderResponse fromAggregate(Order order) {
        return new OrderResponse(order.id().value(), 
        		order.groceryId().value(), 
        		order.customerId().value(),
        		order.amountTotal().value(),
        		order.totalItems().value(),
        		order.dateCreation().value());
    }

    public String id() {
    	return id;
    }
    public String groceryId() {
    	return groceryId;
    }
    public String customerId() {
    	return customerId;
    }
    public Double amountTotal() {
    	return amountTotal;
    }
    public Integer totalItems() {
    	return totalItems;
    }
    public String dateCreation() {
    	return dateCreation;
    }
}
