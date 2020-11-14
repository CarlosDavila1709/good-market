package store.market.administration.shopping_cart_item.domain;

import java.util.Objects;

import store.market.administration.grocery.domain.BackofficeGroceryId;
import store.market.administration.shopping_cart.domain.ShoppingCartId;
import store.market.shared.domain.AggregateRoot;


public final class CartItem extends AggregateRoot {
	
	private final CartItemId id;
	
	private final ShoppingCartId shoppingCartId;
	
	private final ShoppingCartSessionId sessionId;
	
	private final CartItemProductId productId;

	private final CartItemProductPrice productPrice;
	
	private final CartItemProductName productName;
	
	private CartItemAmountTotal amountTotal;
	
	private CartItemQuantity quantity;

	private BackofficeGroceryId groceryId;
	
	public CartItem(
			CartItemId id,
			ShoppingCartId shoppingCartId,
			ShoppingCartSessionId sessionId,
			CartItemProductId productId,
			CartItemProductPrice productPrice,
			CartItemProductName productName,
			CartItemQuantity quantity,
			BackofficeGroceryId groceryId) {

		this.id = id;
		this.shoppingCartId = shoppingCartId;
		this.sessionId = sessionId;
		this.productId = productId;
		this.productPrice = productPrice;
		this.productName = productName;
		this.amountTotal = new CartItemAmountTotal(0.00);
		this.quantity = quantity;
		this.groceryId = groceryId;
	}
	
	
	public CartItem() {
		this.id = null;
		this.shoppingCartId = null;
		this.sessionId = null;
		this.productId = null;
		this.productPrice = null;
		this.productName = null;
		this.amountTotal = null;
		this.quantity = null;
		this.groceryId = null;
	}
	
	public static CartItem initialize(
			CartItemId id,
			ShoppingCartId shoppingCartId,
			ShoppingCartSessionId sessionId,
			CartItemProductId productId,
			CartItemProductPrice productPrice,
			CartItemProductName productName,
			BackofficeGroceryId groceryId) {
		
		CartItem cartItem = new  CartItem(id,shoppingCartId,sessionId,productId,productPrice,productName,CartItemQuantity.initialize(),groceryId);

		return cartItem;
		
	}
    public void increment(CartItemQuantity quantity) {
    	
    	this.quantity = this.quantity.increment(quantity);
       
    }	
    public void addAmount(CartItemProductPrice productPrice,CartItemQuantity quantity) {
		
		Double amountTotalByQuantity = productPrice.value() * quantity.value();
		
		this.amountTotal = this.amountTotal.increment(amountTotalByQuantity);

	}
	public CartItemId id() {
		return id;
	}
	public ShoppingCartId shoppingCartId() {
		return shoppingCartId;
	}
	public CartItemProductId productId() {
		return productId;
	}
	public CartItemProductName productName() {
		
		return productName;
	}
	public ShoppingCartSessionId sessionId() {
		
		return sessionId;
	}
	public CartItemProductPrice productPrice() {
		
		return productPrice;
	}
	public CartItemAmountTotal amountTotal() {
		
		return amountTotal;
	}
	public CartItemQuantity quantity() {
		
		return quantity;
	}
	public BackofficeGroceryId groceryId() {
		return groceryId;
	}
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CartItem cartItem = (CartItem) o;
        return id.equals(cartItem.id) &&
        		shoppingCartId.equals(cartItem.shoppingCartId) &&
        		sessionId.equals(cartItem.sessionId) &&
        		productId.equals(cartItem.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,shoppingCartId,sessionId,productId, productPrice,productName,amountTotal,quantity,groceryId);
    }

}
