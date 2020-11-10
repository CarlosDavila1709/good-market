package store.market.administration.customer.application.find;

import store.market.shared.domain.bus.query.Query;

public final class FindCustomerQuery implements Query{

    private final String id;

    public FindCustomerQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
    
}
