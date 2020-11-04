package store.market.administration.categorie.application.find;

import store.market.shared.domain.bus.query.Query;

public final class FindCategorieQuery implements Query  {

    private final String id;

    public FindCategorieQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
