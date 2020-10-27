package store.market.administration.product.application.find;

import store.market.shared.domain.bus.query.Query;

public final class FindProductQuery implements Query {

    private final String id;

    public FindProductQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
    
}
