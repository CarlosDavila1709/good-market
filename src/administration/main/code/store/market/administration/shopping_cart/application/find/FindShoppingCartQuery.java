package store.market.administration.shopping_cart.application.find;

import store.market.shared.domain.bus.query.Query;

public final class FindShoppingCartQuery implements Query {

    private final String id;

    public FindShoppingCartQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
