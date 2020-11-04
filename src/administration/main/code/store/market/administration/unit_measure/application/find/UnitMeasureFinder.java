package store.market.administration.unit_measure.application.find;


import store.market.administration.unit_measure.application.UnitMeasureResponse;
import store.market.administration.unit_measure.domain.UnitMeasureId;
import store.market.administration.unit_measure.domain.UnitMeasureNotExist;
import store.market.administration.unit_measure.domain.UnitMeasureRepository;
import store.market.shared.domain.Service;

@Service
public final class UnitMeasureFinder {

	private final UnitMeasureRepository repository;
	
	public UnitMeasureFinder(UnitMeasureRepository repository) {
		
		this.repository = repository;
	}
	
    public UnitMeasureResponse find(UnitMeasureId id) throws UnitMeasureNotExist {
        return repository.search(id)
                         .map(UnitMeasureResponse::fromAggregate)
                         .orElseThrow(() -> new UnitMeasureNotExist(id));
    }
}
