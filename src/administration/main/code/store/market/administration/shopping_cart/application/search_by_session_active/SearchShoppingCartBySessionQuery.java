package store.market.administration.shopping_cart.application.search_by_session_active;

import java.util.Objects;

import store.market.shared.domain.bus.query.Query;

public final class SearchShoppingCartBySessionQuery implements Query{

	private final String sessionId;
	
	public SearchShoppingCartBySessionQuery(String sessionId) {
		
		this.sessionId = sessionId;
	}
	public String sessionId() {
		return sessionId;
	}
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SearchShoppingCartBySessionQuery that = (SearchShoppingCartBySessionQuery) o;
        return sessionId.equals(that.sessionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessionId);
    }
}
