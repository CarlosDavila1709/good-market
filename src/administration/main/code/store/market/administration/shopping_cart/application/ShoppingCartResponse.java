package store.market.administration.shopping_cart.application;

import store.market.administration.shopping_cart.domain.ShoppingCart;
import store.market.shared.domain.bus.query.Response;

public final class ShoppingCartResponse implements Response{

	private final String id;
	
	private final String sessionId;

	private final Double amountTotal;
	
	private final Integer totalItems;
	
	public ShoppingCartResponse(String id,String sessionId,Double amountTotal,Integer totalItems) {
		
		this.id = id;
		this.sessionId = sessionId;
		this.amountTotal = amountTotal;
		this.totalItems = totalItems;
	}
    public static ShoppingCartResponse fromAggregate(ShoppingCart shoppingCart) {
        return new ShoppingCartResponse(
        		shoppingCart.id().value(),
        		shoppingCart.sessionId().value(),
        		shoppingCart.amountTotal().value(),
        		shoppingCart.totalItems().value());
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
}
