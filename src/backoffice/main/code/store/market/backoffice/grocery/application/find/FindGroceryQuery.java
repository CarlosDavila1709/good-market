package store.market.backoffice.grocery.application.find;

import store.market.shared.domain.bus.query.Query;

public final class FindGroceryQuery implements Query{

    private final String id;

    public FindGroceryQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
    
}
