package store.market.administration.unit_measure.application.delete;

import store.market.administration.unit_measure.domain.UnitMeasureId;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.command.CommandHandler;

@Service
public final class UnitMeasureCommandHandler implements CommandHandler<UnitMeasureCommand>{

	private UnitMeasureDeleter deleter;
	
	public UnitMeasureCommandHandler(UnitMeasureDeleter deleter) {
		
		this.deleter = deleter;
	}
	@Override
	public void handle(UnitMeasureCommand command) {
	
		UnitMeasureId id = new UnitMeasureId(command.id());
		deleter.delete(id);
	}

}
