package store.market.administration.unit_measure.application.search_all;

import java.util.stream.Collectors;

import store.market.administration.unit_measure.application.UnitMeasureResponse;
import store.market.administration.unit_measure.application.UnitMeasuresResponse;
import store.market.administration.unit_measure.domain.UnitMeasureRepository;
import store.market.shared.domain.Service;

@Service
public final class AllUnitMeasureSearch {

	private final UnitMeasureRepository repository;
	
	public AllUnitMeasureSearch(UnitMeasureRepository repository) {
		
		this.repository = repository;
	}
	
	public UnitMeasuresResponse search() {
		return new UnitMeasuresResponse(
				repository.searchAll().stream().map(UnitMeasureResponse::fromAggregate).collect(Collectors.toList())
		);
	}
}
