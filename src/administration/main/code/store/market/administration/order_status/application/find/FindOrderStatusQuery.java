package store.market.administration.order_status.application.find;

import store.market.shared.domain.bus.query.Query;

public final class FindOrderStatusQuery implements Query{

    private final String id;
    
    public FindOrderStatusQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
