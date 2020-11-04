package store.market.administration.shopping_cart_item.application.search_by_session_product;

import java.util.Objects;

import store.market.shared.domain.bus.query.Query;

public final class SearchCartItemBySessionProductQuery implements Query{

	private final String sessionId;
	private final String productId;
	
	public SearchCartItemBySessionProductQuery(String sessionId,String productId) {
		
		this.sessionId = sessionId;
		this.productId = productId;
	}
	public String sessionId() {
		return sessionId;
	}
	public String productId() {
		return productId;
	}
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SearchCartItemBySessionProductQuery that = (SearchCartItemBySessionProductQuery) o;
        return sessionId.equals(that.sessionId) &&
        		productId.equals(that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessionId,productId);
    }
}
