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
	
	private final String unitMeasureName;
	
	private final String categorieName;
	
	public CartItemResponse(String id,String sessionId,String productId,Double productPrice,String productName,Double amountTotal,Integer quantity,String unitMeasureName,String categorieName) {
		
		this.id = id;
		this.sessionId = sessionId;
		this.productId = productId;
		this.productPrice = productPrice;
		this.productName = productName;
		this.amountTotal = amountTotal;
		this.quantity = quantity;
		this.unitMeasureName = unitMeasureName;
		this.categorieName   = categorieName;
	}
    public static CartItemResponse fromAggregate(CartItem cartItem) {
        return new CartItemResponse(
        		cartItem.id().value(),
        		cartItem.sessionId().value(),
        		cartItem.productId().value(),
        		cartItem.productPrice().value(),
        		cartItem.productName().value(),
        		cartItem.amountTotal().value(),
        		cartItem.quantity().value(),
        		cartItem.unitMeasureName().value(),
        		cartItem.categorieName().value());
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
    public String unitMeasureName() {
    	return unitMeasureName;
    }
    public String categorieName() {
    	return categorieName;
    }
}
