package store.market.administration.order_item.application.search_by_order;

import java.util.Objects;

import store.market.shared.domain.bus.query.Query;

public final class SearchItemsByOrderQuery implements Query{

	private String orderId;
	
	public SearchItemsByOrderQuery(String orderId) {
		
		this.orderId = orderId;
	}
	
	public String orderId() {
		return orderId;
	}
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SearchItemsByOrderQuery that = (SearchItemsByOrderQuery) o;
        return orderId.equals(that.orderId) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }
}
