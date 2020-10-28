package store.market.administration.shopping_cart.domain;

import store.market.shared.domain.AggregateRoot;

public final class ShoppingCard extends AggregateRoot{

	private final ShoppingCard id;

	private CardAmountTotal amountTotal;
	
	public ShoppingCard(ShoppingCard id, CardAmountTotal amountTotal) {
		this.id = id;
		this.amountTotal = amountTotal;
	}
	public ShoppingCard() {
		this.id = null;
		this.amountTotal = null;
	}
	public CardAmountTotal amountTotal() {
		return amountTotal;
	}
	public ShoppingCard id() {
		return id;
	}
	public void addAmount(CardAmountTotal amountTotal) {
		
		this.amountTotal = amountTotal.increment(amountTotal.value());
	}
	public void subtractAmount(CardAmountTotal amountTotal) {
		
		this.amountTotal = amountTotal.subtract(amountTotal.value());
	}
}
