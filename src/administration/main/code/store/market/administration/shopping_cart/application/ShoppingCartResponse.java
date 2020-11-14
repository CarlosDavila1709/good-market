package store.market.administration.shopping_cart.application;

import java.util.ArrayList;
import java.util.List;

import store.market.administration.shopping_cart.domain.ShoppingCart;
import store.market.shared.domain.bus.query.Response;

public final class ShoppingCartResponse implements Response{

	private final String id;
	
	private final String groceryId;
	
	private final String sessionId;

	private final Double amountTotal;
	
	private final Integer totalItems;
	
	private final List<String> existingProducts;
	
	public ShoppingCartResponse(String id,String groceryId,String sessionId,Double amountTotal,Integer totalItems,List<String> existingProducts) {
		
		this.id = id;
		this.sessionId = sessionId;
		this.amountTotal = amountTotal;
		this.totalItems = totalItems;
		this.groceryId = groceryId;
		this.existingProducts = existingProducts;
	}
    public static ShoppingCartResponse fromAggregate(ShoppingCart shoppingCart) {
    	
    	List<String> productList = new ArrayList<String>();
    	shoppingCart.existingProducts().forEach(product -> productList.add(product.value()));
    	
        return new ShoppingCartResponse(
        		shoppingCart.id().value(),
        		shoppingCart.groceryId().value(),
        		shoppingCart.sessionId().value(),
        		shoppingCart.amountTotal().value(),
        		shoppingCart.totalItems().value(),
        		productList);
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
    public Integer totalItems() {
    	return totalItems;
    }
    public String groceryId() {
    	return groceryId;
    }
    public List<String> existingProducts() {
    	return existingProducts;
    }

}
