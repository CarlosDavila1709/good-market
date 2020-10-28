package store.market.administration.unit_measure.application.create;

import store.market.administration.unit_measure.domain.UnitMeasure;
import store.market.administration.unit_measure.domain.UnitMeasureId;
import store.market.administration.unit_measure.domain.UnitMeasureName;
import store.market.administration.unit_measure.domain.UnitMeasurePrefix;
import store.market.administration.unit_measure.domain.UnitMeasureRepository;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.event.EventBus;

@Service
public final class UnitMeasureCreator {

	private final UnitMeasureRepository repository;
	
	private final EventBus eventBus;
	
	public UnitMeasureCreator(UnitMeasureRepository repository,EventBus eventBus) {
		this.repository = repository;
		this.eventBus = eventBus;
	}
	public void create(UnitMeasureId id, UnitMeasureName name, UnitMeasurePrefix prefix) {
		
		UnitMeasure unitMeasure = UnitMeasure.create(id, name, prefix);
		
		repository.save(unitMeasure);
		
		eventBus.publish(unitMeasure.pullDomainEvents());
		
	}
}
