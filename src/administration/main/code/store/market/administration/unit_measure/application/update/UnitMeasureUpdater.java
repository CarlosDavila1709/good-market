package store.market.administration.unit_measure.application.update;

import store.market.administration.unit_measure.domain.UnitMeasure;
import store.market.administration.unit_measure.domain.UnitMeasureId;
import store.market.administration.unit_measure.domain.UnitMeasureName;
import store.market.administration.unit_measure.domain.UnitMeasureNotExist;
import store.market.administration.unit_measure.domain.UnitMeasurePrefix;
import store.market.administration.unit_measure.domain.UnitMeasureRepository;
import store.market.shared.domain.Service;

@Service
public final class UnitMeasureUpdater {

	private UnitMeasureRepository repository;

	public UnitMeasureUpdater(UnitMeasureRepository repository) {
		
		this.repository = repository;

	}
	
	public void update(UnitMeasureId id, UnitMeasureName name,UnitMeasurePrefix prefix) {
		UnitMeasure unitMeasure = repository.search(id).orElseThrow(()-> {throw new UnitMeasureNotExist(id);});
		
		unitMeasure.updateName(name);
		unitMeasure.updatePrefix(prefix);
		
		repository.save(unitMeasure);
		
	}
}
