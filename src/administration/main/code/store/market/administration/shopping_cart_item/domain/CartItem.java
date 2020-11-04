package store.market.administration.shopping_cart_item.domain;

import java.util.Objects;

import store.market.shared.domain.AggregateRoot;
import store.market.shared.domain.cart_item.CartItemCreatedDomainEvent;

public final class CartItem extends AggregateRoot {
	
	private final CartItemId id;
	
	private final ShoppingCartSessionId sessionId;
	
	private final CartItemProductId productId;

	private final CartItemProductPrice productPrice;
	
	private final CartItemProductName productName;
	
	private final CartItemAmountTotal amountTotal;
	
	private final CartItemQuantity quantity;

	public CartItem(
			CartItemId id,
			ShoppingCartSessionId shoppingCartId,
			CartItemProductId productId,
			CartItemProductPrice productPrice,
			CartItemProductName productName,
			CartItemQuantity quantity) {

		this.id = id;
		this.sessionId = shoppingCartId;
		this.productId = productId;
		this.productPrice = productPrice;
		this.productName = productName;
		this.amountTotal = new CartItemAmountTotal(0.00);
		this.quantity = quantity;
	}
	
	
	public CartItem() {
		this.id = null;
		this.sessionId = null;
		this.productId = null;
		this.productPrice = null;
		this.productName = null;
		this.amountTotal = null;
		this.quantity = null;
	}
	
	public static CartItem create(
			CartItemId id,
			ShoppingCartSessionId shoppingCartSession,
			CartItemProductId productId,
			CartItemProductPrice productPrice,
			CartItemProductName productName,
			CartItemQuantity quantity) {
		
		CartItem cartItem = new  CartItem(id,shoppingCartSession,productId,productPrice,productName,quantity);
		
		cartItem.record(new CartItemCreatedDomainEvent(productId.value(),productName.value()));
		
		return cartItem;
		
	}
    public void increment(CartItemQuantity quantity) {
    	
    	quantity = quantity.increment(quantity);
       
    }
	public CartItemId id() {
		return id;
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
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CartItem cartItem = (CartItem) o;
        return id.equals(cartItem.id) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,sessionId,productId, productPrice,productName,amountTotal,quantity);
    }
}
