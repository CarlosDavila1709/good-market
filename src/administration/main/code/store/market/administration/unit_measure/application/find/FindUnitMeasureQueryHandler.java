package store.market.administration.unit_measure.application.find;

import store.market.administration.unit_measure.application.UnitMeasureResponse;
import store.market.administration.unit_measure.domain.UnitMeasureId;
import store.market.administration.unit_measure.domain.UnitMeasureNotExist;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.query.QueryHandler;

@Service
public final class FindUnitMeasureQueryHandler implements QueryHandler<FindUnitMeasureQuery, UnitMeasureResponse>{

    private final UnitMeasureFinder finder;

    public FindUnitMeasureQueryHandler(UnitMeasureFinder finder) {
        this.finder = finder;
    }

    @Override
    public UnitMeasureResponse handle(FindUnitMeasureQuery query) throws UnitMeasureNotExist {
        return finder.find(new UnitMeasureId(query.id()));
    }
	
}
