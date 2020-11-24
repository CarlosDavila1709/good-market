package store.market.administration.unit_measure.application.update;

import store.market.shared.domain.bus.command.Command;

public class UpdateUnitMeasureCommand implements Command{

	private String id;
	private String name;
	private String prefix;
	
	public UpdateUnitMeasureCommand(String id,String name,String prefix) {
		
		this.id = id;
		this.name = name;
		this.prefix = prefix;
	}
	
	public String id() {
		return id;
	}
	public String name() {
		return name;
	}
	public String prefix() {
		return prefix;
	}
}
