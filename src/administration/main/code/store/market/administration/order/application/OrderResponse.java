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
	private String codigoStatus;
	private String descriptionStatus;
	private String nameCustomer;
    
    private String customerPhone;
    private String customerAddress;
    
	public OrderResponse(String id,
			String groceryId,
			String customerId,
			Double amountTotal,
			Integer totalItems,
			String dateCreation,
			String codigoStatus,
			String descriptionStatus,
			String nameCustomer,
			String customerPhone,
			String customerAddress) {
		this.id = id;
		this.groceryId = groceryId;
		this.customerId = customerId;
		this.amountTotal = amountTotal;
		this.totalItems = totalItems;
		this.dateCreation = dateCreation;
		this.codigoStatus = codigoStatus;
		this.descriptionStatus = descriptionStatus;	
		this.nameCustomer = nameCustomer;
		this.customerPhone = customerPhone;
		this.customerAddress = customerAddress;
	}
    public static OrderResponse fromAggregate(Order order) {
        return new OrderResponse(order.id().value(), 
        		order.groceryId().value(), 
        		order.customerId().value(),
        		order.amountTotal().value(),
        		order.totalItems().value(),
        		order.dateCreation().value(),
        		order.status().value(),
        		order.descriptionStatus(),
        		order.nameCustomer(),
        		order.customerPhone(),
        		order.customerAddress());
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
    public String codigoStatus() {
    	return codigoStatus;
    }
    public String descriptionStatus() {
    	return descriptionStatus;
    }
    public String nameCustomer() {
    	return nameCustomer;
    }
    public String customerPhone() {
    	return customerPhone;
    }
    public String customerAddress() {
    	return customerAddress;
    }
}
