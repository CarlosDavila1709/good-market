package store.market.administration.unit_measure.application.search_all;

import java.util.Objects;

import store.market.shared.domain.bus.query.Query;

public final class SearchAllUnitMeasuresQuery  implements Query{

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        return o != null && getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash("SearchAllUnitMeasuresQuery");
    }
    
}
