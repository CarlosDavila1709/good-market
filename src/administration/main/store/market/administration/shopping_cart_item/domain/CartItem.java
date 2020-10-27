package store.market.administration.shopping_cart_item.domain;

import java.util.Objects;

import store.market.shared.domain.AggregateRoot;
import store.market.shared.domain.cart_item.CartItemCreatedDomainEvent;

public final class CartItem extends AggregateRoot {

	private final CartProductId productId;
	
	private final CartProductPrice productPrice;
	
	private final CartProductName productName;
	
	private final CartAmountTotal amountTotal;

	public CartItem(CartProductId productId,
			CartProductPrice productPrice,
			CartProductName productName,
			CartAmountTotal amountTotal) {
		
		this.productId = productId;
		this.productPrice = productPrice;
		this.productName = productName;
		this.amountTotal = amountTotal;
	}
	
	
	public CartItem() {
		
		this.productId = null;
		this.productPrice = null;
		this.productName = null;
		this.amountTotal = null;
	}
	
	public static CartItem create(CartProductId productId,
			CartProductPrice productPrice,
			CartProductName productName,
			CartAmountTotal amountTotal) {
		
		CartItem cartItem = new  CartItem(productId,productPrice,productName,amountTotal);
		
		cartItem.record(new CartItemCreatedDomainEvent(productId.value(),productName.value()));
		
		return cartItem;
		
	}
	
	public CartProductId productId() {
		return productId;
	}
	public CartProductName productName() {
		
		return productName;
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
        return productId.equals(cartItem.productId) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productPrice,productName,amountTotal);
    }
}
