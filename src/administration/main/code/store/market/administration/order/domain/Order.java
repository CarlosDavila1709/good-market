package store.market.administration.order.domain;

import java.util.List;
import java.util.Objects;

import store.market.administration.customer.application.CustomerResponse;
import store.market.administration.customer.domain.CustomerId;
import store.market.administration.grocery.domain.BackofficeGroceryId;
import store.market.administration.product_catalog.domain.ProductCatalogId;
import store.market.administration.shopping_cart.application.ShoppingCartResponse;
import store.market.shared.domain.AggregateRoot;
import store.market.shared.domain.orders.OrderCreatedDomainEvent;

public final class Order extends AggregateRoot{

	private OrderId id;
	private BackofficeGroceryId groceryId;
	private CustomerId customerId;
	private OrderAmountTotal amountTotal;
	private OrderCounterItems totalItems;
	private OrderStatus status;
	private String descriptionStatus;
	private String nameCustomer;
    private List<ProductCatalogId> existingProducts;
    private OrderDateCreation dateCreation;
    
    private String customerPhone;
    private String customerAddress;
	
    public Order(OrderId id, BackofficeGroceryId groceryId, 
    		CustomerId customerId,
    		OrderAmountTotal amountTotal,
    		OrderCounterItems totalItems,
    		OrderStatus status,List<ProductCatalogId> existingProducts,
    		OrderDateCreation dateCreation,
    		String descriptionStatus,
    		String nameCustomer,
    		String customerPhone,
    		String customerAddress) {
        this.id               = id;
        this.groceryId        = groceryId;
        this.customerId 	  = customerId;
        this.amountTotal 	  = amountTotal;
        this.totalItems 	  = totalItems;
        this.status	 		  = status;
        this.existingProducts = existingProducts;
        this.dateCreation     = dateCreation;
        this.descriptionStatus= descriptionStatus;
        this.nameCustomer     = nameCustomer;
        this.customerPhone    = customerPhone;
        this.customerAddress  = customerAddress;
    }
    public Order() {
        this.id             = null;
        this.groceryId      = null;
        this.customerId 	= null;
        this.amountTotal 	= null;
        this.totalItems 	= null;
        this.status 		= null;
        this.existingProducts = null;
        this.dateCreation     = null;
        this.nameCustomer     = null;
        this.customerPhone     = null;
        this.customerAddress     = null;
    }
    
    public static Order create(OrderId id, 
    		OrderStatus status,
    		CustomerResponse customer,
    		ShoppingCartResponse shopping,List<ProductCatalogId> existingProducts,
    		OrderDateCreation dateCreation,
    		String descriptionStatus,
    		String nameCustomer,
    		String customerPhone,
    		String customerAddress) {
        
    	Order order = new Order( id,  
    			new BackofficeGroceryId(shopping.groceryId()),  
    			new CustomerId(customer.id()), 
    			new OrderAmountTotal(shopping.amountTotal()), 
    			new OrderCounterItems( shopping.totalItems()), 
    			status, 
    			existingProducts,
    			dateCreation,
    			descriptionStatus,
    			nameCustomer,
    			customerPhone,
    			customerAddress);

    	order.record(new OrderCreatedDomainEvent(id.value(), shopping.sessionId(),shopping.id()));
        return order;
    }
    public void incrementProduct(ProductCatalogId id) {
       
    	existingProducts.add(id);
    }
    public OrderId id() {
    	return id;
    }
    public BackofficeGroceryId groceryId() {
    	return groceryId;
    }
    public CustomerId customerId() {
    	return customerId;
    }
    public OrderAmountTotal amountTotal() {
    	return amountTotal;
    }
    public OrderCounterItems totalItems() {
    	return totalItems;
    }
    public OrderStatus status() {
    	return status;
    }
    public List<ProductCatalogId> existingProducts() {
    	return existingProducts;
    }
    public OrderDateCreation dateCreation() {
    	return dateCreation;
    }
    public String customerPhone() {
    	return customerPhone;
    }
    public String customerAddress() {
    	return customerAddress;
    }
    public String descriptionStatus() {
    	return descriptionStatus;
    }
    public String nameCustomer() {
    	return nameCustomer;
    }
    public void updateStatus(OrderStatus status) {
    	this.status = status;
    }
    public void updateDescriptionStatus(String descriptionStatus) {
    	this.descriptionStatus = descriptionStatus;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order that = (Order) o;
        return id.equals(that.id) &&
        		groceryId.equals(that.groceryId) &&
        		customerId.equals(that.customerId) &&
        		amountTotal.equals(that.amountTotal) &&
        		totalItems.equals(that.totalItems) &&
        		status.equals(that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,  groceryId,  customerId, amountTotal, totalItems, status, existingProducts,dateCreation,nameCustomer,customerPhone,customerAddress);
    }
}
