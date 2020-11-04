package store.market.administration.shopping_cart.domain;

import java.util.Objects;

import store.market.shared.domain.AggregateRoot;
import store.market.shared.domain.shopping_cart.ShoppingCartCreatedDomainEvent;

public final class ShoppingCart extends AggregateRoot{
	
	private final ShoppingCartId id;
	
	private final ShoppingCartSessionId sessionId;

	private ShoppingCartAmountTotal amountTotal;
	
	private ShoppingCartCounterItems totalItems;
	
	public ShoppingCart(ShoppingCartId id,ShoppingCartSessionId sessionId, ShoppingCartAmountTotal amountTotal) {
		this.id = id;
		this.sessionId = sessionId;
		this.amountTotal = amountTotal;
	}
	public static ShoppingCart create(ShoppingCartId id,ShoppingCartSessionId sessionId, ShoppingCartAmountTotal amountTotal) {
		
		ShoppingCart shoppingCart = new ShoppingCart( id, sessionId, amountTotal);
		
		shoppingCart.record(new ShoppingCartCreatedDomainEvent(id.value(), sessionId.value()));
		
		return shoppingCart;
	}
	
	public ShoppingCart() {
		this.id = null;
		this.sessionId = null;
		this.amountTotal = null;
		this.totalItems = null;
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
	public void addAmount(ShoppingCartAmountTotal amountTotal) {
		
		this.amountTotal = amountTotal.increment(amountTotal.value());
	}
	public void subtractAmount(ShoppingCartAmountTotal amountTotal) {
		
		this.amountTotal = amountTotal.subtract(amountTotal.value());
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
        		sessionId.equals(shoppingCart.sessionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sessionId,amountTotal);
    }
}
