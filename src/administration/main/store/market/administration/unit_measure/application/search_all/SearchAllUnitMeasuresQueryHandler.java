package store.market.administration.unit_measure.application.search_all;

import store.market.administration.unit_measure.application.UnitMeasuresResponse;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.query.QueryHandler;

@Service
public final class SearchAllUnitMeasuresQueryHandler implements QueryHandler<SearchAllUnitMeasuresQuery, UnitMeasuresResponse>{

	private final AllUnitMeasureSearch searcher;
	
    public SearchAllUnitMeasuresQueryHandler(AllUnitMeasureSearch searcher) {
        this.searcher = searcher;
    }

    @Override
    public UnitMeasuresResponse handle(SearchAllUnitMeasuresQuery query) {
        return searcher.search();
    }
}
