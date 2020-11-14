package store.market.administration.shopping_cart_item.application.search_by_cart;

import java.util.Objects;

import store.market.shared.domain.bus.query.Query;

public final class SearchCartItemByCartQuery  implements Query{

	private String shoppingCartId;
	
	public SearchCartItemByCartQuery(String shoppingCartId) {
	
		this.shoppingCartId = shoppingCartId;
	}
	public String shoppingCartId() {
		return shoppingCartId;
	}
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SearchCartItemByCartQuery that = (SearchCartItemByCartQuery) o;
        return shoppingCartId.equals(that.shoppingCartId) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(shoppingCartId);
    }
}
