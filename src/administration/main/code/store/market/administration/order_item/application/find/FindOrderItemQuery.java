package store.market.administration.order_item.application.find;

import store.market.shared.domain.bus.query.Query;

public final class FindOrderItemQuery implements Query{

    private final String id;

    public FindOrderItemQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
