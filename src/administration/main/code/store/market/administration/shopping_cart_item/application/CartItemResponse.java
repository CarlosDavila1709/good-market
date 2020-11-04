package store.market.administration.shopping_cart_item.application;

import store.market.administration.shopping_cart_item.domain.CartItem;
import store.market.shared.domain.bus.query.Response;

public final class CartItemResponse implements Response{

	private final String id;
	
	private final String sessionId;
	
	private final String productId;

	private final Double productPrice;
	
	private final String productName;
	
	private final Double amountTotal;
	
	private final Integer quantity;
	
	public CartItemResponse(String id,String sessionId,String productId,Double productPrice,String productName,Double amountTotal,Integer quantity) {
		
		this.id = id;
		this.sessionId = sessionId;
		this.productId = productId;
		this.productPrice = productPrice;
		this.productName = productName;
		this.amountTotal = amountTotal;
		this.quantity = quantity;
	}
    public static CartItemResponse fromAggregate(CartItem CartItem) {
        return new CartItemResponse(
        		CartItem.id().value(),
        		CartItem.sessionId().value(),
        		CartItem.productId().value(),
        		CartItem.productPrice().value(),
        		CartItem.productName().value(),
        		CartItem.amountTotal().value(),
        		CartItem.quantity().value());
    }
    public String id() {
    	return id;
    }
    public String sessionId() {
    	return sessionId;
    }
    public String productId() {
    	return productId;
    }
    public Double productPrice() {
    	return productPrice;
    }
    public String productName() {
    	return productName;
    }
    public Double amountTotal() {
    	return amountTotal;
    }
    public Integer quantity() {
    	return quantity;
    }
}
