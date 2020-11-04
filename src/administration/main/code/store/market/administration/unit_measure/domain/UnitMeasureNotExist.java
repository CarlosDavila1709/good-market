package store.market.administration.unit_measure.domain;

import store.market.shared.domain.DomainError;

public final class UnitMeasureNotExist extends DomainError{

    public UnitMeasureNotExist(UnitMeasureId id) {
        super("unitMeasure_not_exist", String.format("The unit measure <%s> doesn't exist", id.value()));
    }
}
