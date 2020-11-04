package store.market.administration.shopping_cart_item.application.find;

import store.market.shared.domain.bus.query.Query;

public final class FindCartItemQuery implements Query {

    private final String id;

    public FindCartItemQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
