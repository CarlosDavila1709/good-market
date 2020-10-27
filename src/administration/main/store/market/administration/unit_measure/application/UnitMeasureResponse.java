package store.market.administration.unit_measure.application;

import store.market.administration.unit_measure.domain.UnitMeasure;
import store.market.shared.domain.bus.query.Response;

public final class UnitMeasureResponse implements Response {

	private final String id;
	
	private final String name;
	
	private final String prefix;
	
	public UnitMeasureResponse(String id, String name, String prefix) {
		
		this.id = id;
		this.name = name;
		this.prefix = prefix;
	}
	
	public static UnitMeasureResponse fromAggregate(UnitMeasure unitMeasure) {
		
		return new UnitMeasureResponse(unitMeasure.id().value(),unitMeasure.name().value(),unitMeasure.prefix().value());
		
	}
	
	public String id(){
		return id;
	}
	public String name() {
		return name;
	}
	public String prefix() {
		return prefix;
	}
}
