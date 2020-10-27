package store.market.administration.categorie.application.search_all;

import store.market.shared.domain.bus.query.Query;

import java.util.Objects;

public final class SearchAllCategoriesQuery implements Query{

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        return o != null && getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash("SearchAllCategoriesQuery");
    }
}
