package store.market.administration.unit_measure.application.create;

import store.market.administration.unit_measure.domain.UnitMeasureId;
import store.market.administration.unit_measure.domain.UnitMeasureName;
import store.market.administration.unit_measure.domain.UnitMeasurePrefix;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateUnitMeasureCommandHandler implements CommandHandler<CreateUnitMeasureCommand>{

	private final UnitMeasureCreator creator;
	
	public CreateUnitMeasureCommandHandler(UnitMeasureCreator creator) {
	
		this.creator = creator;
	}
	
    @Override
    public void handle(CreateUnitMeasureCommand command) {
    	UnitMeasureId       id       = new UnitMeasureId(command.id());
    	UnitMeasureName     name     = new UnitMeasureName(command.name());
    	UnitMeasurePrefix   prefix   = new UnitMeasurePrefix(command.prefix());

        creator.create(id, name, prefix);
    }
}
