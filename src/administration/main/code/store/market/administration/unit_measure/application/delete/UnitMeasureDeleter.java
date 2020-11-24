package store.market.administration.unit_measure.application.delete;

import store.market.administration.unit_measure.domain.UnitMeasure;
import store.market.administration.unit_measure.domain.UnitMeasureId;
import store.market.administration.unit_measure.domain.UnitMeasureNotExist;
import store.market.administration.unit_measure.domain.UnitMeasureRepository;
import store.market.shared.domain.Service;

@Service
public final class UnitMeasureDeleter {

	private UnitMeasureRepository repository;
	
	public UnitMeasureDeleter( UnitMeasureRepository repository) {
		
		this.repository = repository;
	}
	
	public void delete(UnitMeasureId id) {
		
		UnitMeasure unitMeasure = repository.search(id).orElseThrow(()-> {throw new UnitMeasureNotExist(id);});
		
		repository.delete(unitMeasure);
	}
}
