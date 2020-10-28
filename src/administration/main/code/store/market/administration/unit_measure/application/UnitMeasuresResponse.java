package store.market.administration.unit_measure.application;

import java.util.List;

import store.market.shared.domain.bus.query.Response;

public final class UnitMeasuresResponse implements Response {

	public final List<UnitMeasureResponse> unitMeasures;

	public UnitMeasuresResponse(List<UnitMeasureResponse> unitMeasures) {
	
		this.unitMeasures = unitMeasures;
	}
	
	public List<UnitMeasureResponse> unitMeasures(){
		return unitMeasures;
	}
}
