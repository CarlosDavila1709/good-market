package store.market.administration.order.application.find;

import store.market.shared.domain.bus.query.Query;

public final class FindOrderQuery implements Query{

    private final String id;

    public FindOrderQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
