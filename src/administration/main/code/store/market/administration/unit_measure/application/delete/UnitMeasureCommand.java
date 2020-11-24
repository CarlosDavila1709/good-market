package store.market.administration.unit_measure.application.delete;

import store.market.shared.domain.bus.command.Command;

public class UnitMeasureCommand implements Command {
	private final String id;
	
	public UnitMeasureCommand(String id) {
		this.id = id;
	}
	public String id() {
        return id;
    }
}
