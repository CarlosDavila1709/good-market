package store.market.administration.shopping_cart.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import store.market.administration.grocery.domain.BackofficeGroceryId;
import store.market.administration.product_catalog.domain.ProductCatalogId;
import store.market.shared.domain.AggregateRoot;
import store.market.shared.domain.shopping_cart.ProductToShoppingCartAggregateDomainEvent;

public final class ShoppingCart extends AggregateRoot{
	
	private final ShoppingCartId 			id;
	
	private final ShoppingCartSessionId 	sessionId;
	
	private final BackofficeGroceryId		groceryId;

	private ShoppingCartAmountTotal 		amountTotal;
	
	private ShoppingCartCounterItems 		totalItems;
	
    private List<ProductCatalogId>      	existingProducts;
	
    private ShoppingCartQuantity 			quantity;
    
    private ShoppingCartStatus status;
    
	public ShoppingCart(ShoppingCartId id,
			ShoppingCartSessionId sessionId, 
			BackofficeGroceryId		groceryId,
			ShoppingCartAmountTotal amountTotal,
			ShoppingCartCounterItems totalItems, 
			List<ProductCatalogId> existingProducts,
			ShoppingCartQuantity quantity,
			ShoppingCartStatus status) {
		
		this.id = id;
		this.sessionId = sessionId;
		this.groceryId = groceryId;
		this.amountTotal = amountTotal;
		this.existingProducts = existingProducts;
		this.totalItems = totalItems;
		this.quantity = quantity;
		this.status = status;
	}

	public ShoppingCart() {
		this.id = null;
		this.sessionId = null;
		this.groceryId = null;
		this.amountTotal = null;
		this.totalItems = null;
		this.existingProducts = null;
		this.quantity = null;
		this.status = null;
	}

    public static ShoppingCart initialize(
    		ShoppingCartId id,
    		ShoppingCartSessionId sessionId,
    		BackofficeGroceryId		groceryId,
    		ShoppingCartStatus status) {
        
    	ShoppingCart shoppingCart = new ShoppingCart( 
    			id, 
    			sessionId,  
    			groceryId,
    			new ShoppingCartAmountTotal(0.00), 
    			ShoppingCartCounterItems.initialize(), 
    			new ArrayList<>(), 
    			ShoppingCartQuantity.initialize(),
    			status);

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
	public List<ProductCatalogId> existingProducts(){
		return existingProducts;
	}
	public ShoppingCartQuantity quantity() {
		return quantity;
	}
	public BackofficeGroceryId	groceryId() {
		return groceryId;
	}
	public ShoppingCartStatus status() {
		return status;
	}
	public void updateStatus(ShoppingCartStatus status) {
		this.status = status;
	}

    public void addProduct(ProductCatalogId productId, ShoppingCartQuantity quantity) {
    	
    	totalItems = totalItems.increment(quantity.value());
    	
    	for(int i = 0; i < quantity.value(); i++) {
        	
    		existingProducts.add(productId);
    	}

    	record(new ProductToShoppingCartAggregateDomainEvent(id.value(),sessionId.value(),productId.value(), quantity.value(), groceryId.value()));
    }
    public void removeProduct(ProductCatalogId productId) {

    	List<ProductCatalogId> operatedList = new ArrayList<>();
    	existingProducts.stream()
    	  .forEach(item -> {
    		  if(item.equals(productId))
    			  operatedList.add(item);
    	});
    	existingProducts.removeAll(operatedList);
    	totalItems = totalItems.decrement(operatedList.size());

    }
	public void addAmount(ShoppingCartAmountTotal amountTotal,ShoppingCartQuantity quantity) {
		Double amountTotalByQuantity = amountTotal.value() * quantity.value();
		this.amountTotal = this.amountTotal.increment(amountTotalByQuantity);

	}
	public void inizializeAmount() {		
		this.amountTotal = ShoppingCartAmountTotal.initialize();
	}
	public void inizializeTotalItems() {		
		this.totalItems = ShoppingCartCounterItems.initialize();
	}
	public void increaseAmount(ShoppingCartAmountTotal amountTotal) {		
		this.amountTotal = this.amountTotal.increment(amountTotal.value());
	}
	public void increaseQuantityItems(ShoppingCartQuantity quantity) {
		this.totalItems = this.totalItems.increment(quantity.value());
	}
	public void subtractAmount(Double priceProduct,ProductCatalogId productId) {

    	existingProducts.forEach(item->{ 
    		if(item.equals(productId)) {
    			this.amountTotal = this.amountTotal.subtract(priceProduct);
    		}
    	});
	}
	
    public boolean existsProduct(ProductCatalogId id) {
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
        return Objects.hash(id, sessionId,groceryId,amountTotal,totalItems,existingProducts,quantity,status);
    }
}
