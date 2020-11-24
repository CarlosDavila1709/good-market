package store.market.administration.unit_measure.application.update;

import store.market.administration.unit_measure.domain.UnitMeasureId;
import store.market.administration.unit_measure.domain.UnitMeasureName;
import store.market.administration.unit_measure.domain.UnitMeasurePrefix;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.command.CommandHandler;

@Service
public final class UpdateUnitMeasureCommandHandler implements CommandHandler<UpdateUnitMeasureCommand>{

	private UnitMeasureUpdater updater;
	
	public UpdateUnitMeasureCommandHandler(UnitMeasureUpdater updater) {
		
		this.updater = updater;
	}
	
	@Override
	public void handle(UpdateUnitMeasureCommand command) {
		UnitMeasureId id = new UnitMeasureId(command.id());
		UnitMeasureName name = new UnitMeasureName(command.name());
		UnitMeasurePrefix prefix = new UnitMeasurePrefix(command.prefix());
		
		updater.update(id, name, prefix);
	}

}
