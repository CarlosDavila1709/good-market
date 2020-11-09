package store.market.administration.shopping_cart.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import store.market.administration.grocery.domain.BackofficeGroceryId;
import store.market.administration.product.domain.ProductId;
import store.market.shared.domain.AggregateRoot;
import store.market.shared.domain.shopping_cart.ProductToShoppingCartAggregateDomainEvent;


public final class ShoppingCart extends AggregateRoot{
	
	private final ShoppingCartId 			id;
	
	private final ShoppingCartSessionId 	sessionId;
	
	private final BackofficeGroceryId		groceryId;

	private ShoppingCartAmountTotal 		amountTotal;
	
	private ShoppingCartCounterItems 		totalItems;
	
    private List<ProductId>      			existingProducts;
	
    private ShoppingCartQuantity 			quantity;
    
	public ShoppingCart(ShoppingCartId id,
			ShoppingCartSessionId sessionId, 
			BackofficeGroceryId		groceryId,
			ShoppingCartAmountTotal amountTotal,
			ShoppingCartCounterItems totalItems, 
			List<ProductId> existingProducts,
			ShoppingCartQuantity quantity) {
		
		this.id = id;
		this.sessionId = sessionId;
		this.groceryId = groceryId;
		this.amountTotal = amountTotal;
		this.existingProducts = existingProducts;
		this.totalItems = totalItems;
		this.quantity = quantity;
	}

	public ShoppingCart() {
		this.id = null;
		this.sessionId = null;
		this.groceryId = null;
		this.amountTotal = null;
		this.totalItems = null;
		this.existingProducts = null;
		this.quantity = null;
	}

    public static ShoppingCart initialize(
    		ShoppingCartId id,
    		ShoppingCartSessionId sessionId,
    		BackofficeGroceryId		groceryId) {
        
    	ShoppingCart shoppingCart = new ShoppingCart( 
    			id, 
    			sessionId,  
    			groceryId,
    			new ShoppingCartAmountTotal(0.00), 
    			ShoppingCartCounterItems.initialize(), 
    			new ArrayList<>(), 
    			ShoppingCartQuantity.initialize());

    	return shoppingCart;
    }
	public ShoppingCartId id() {
		return id;
	}
	public ShoppingCartAmountTotal amountTotal() {
		return amountTotal;
	}
	public ShoppingCartSessionId sessionId() {
		return sessionId;
	}
	public ShoppingCartCounterItems totalItems() {
		return totalItems;
	}
	public List<ProductId> existingProducts(){
		return existingProducts;
	}
	public ShoppingCartQuantity quantity() {
		return quantity;
	}
	public BackofficeGroceryId	groceryId() {
		return groceryId;
	}
	public void addAmount(ShoppingCartAmountTotal amountTotal,ShoppingCartQuantity quantity) {
		
		Double amountTotalByQuantity = amountTotal.value() * quantity.value();
		
		this.amountTotal = this.amountTotal.increment(amountTotalByQuantity);

	}

    public void addProduct(ProductId productId, ShoppingCartQuantity quantity) {
    	
    	totalItems = totalItems.increment(quantity.value());
    	
    	for(int i = 0; i < quantity.value(); i++) {
        	
    		existingProducts.add(productId);
    	}

    	record(new ProductToShoppingCartAggregateDomainEvent(id.value(),sessionId.value(),productId.value(), quantity.value(), groceryId.value()));
    }
    
	public void subtractAmount(ShoppingCartAmountTotal amountTotal) {
		
		this.amountTotal = this.amountTotal.subtract(amountTotal.value());
	}
	
    public boolean existsProduct(ProductId id) {
        return existingProducts.contains(id);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ShoppingCart shoppingCart = (ShoppingCart) o;
        return id.equals(shoppingCart.id) &&
        		sessionId.equals(shoppingCart.sessionId) &&
        		groceryId.equals(shoppingCart.groceryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sessionId,groceryId,amountTotal,totalItems,existingProducts,quantity);
    }
}
