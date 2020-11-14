package store.market.administration.product_catalog.application.find;

import store.market.shared.domain.bus.query.Query;

public final class FindProductCatalogQuery  implements Query {

    private final String id;

    public FindProductCatalogQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
