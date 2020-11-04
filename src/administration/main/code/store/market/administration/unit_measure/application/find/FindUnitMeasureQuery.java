package store.market.administration.unit_measure.application.find;

import store.market.shared.domain.bus.query.Query;

public final class FindUnitMeasureQuery implements Query{

    private final String id;

    public FindUnitMeasureQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
    
}
