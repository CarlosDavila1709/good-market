package store.market.backoffice.grocery.application.search;

import store.market.shared.domain.bus.query.Query;

public final class SearchGroceryQuery  implements Query{

    private final String id;

    public SearchGroceryQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
