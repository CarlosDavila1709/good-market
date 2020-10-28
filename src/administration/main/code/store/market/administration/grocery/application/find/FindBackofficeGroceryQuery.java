package store.market.administration.grocery.application.find;

import store.market.shared.domain.bus.query.Query;

public final class FindBackofficeGroceryQuery implements Query {

    private final String id;

    public FindBackofficeGroceryQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
    
}
