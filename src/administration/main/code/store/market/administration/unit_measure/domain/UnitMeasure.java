package store.market.administration.unit_measure.domain;

import java.util.Objects;

import store.market.administration.grocery.domain.BackofficeGroceryId;
import store.market.shared.domain.AggregateRoot;
import store.market.shared.domain.unit_measure.UnitMeasureCreatedDomainEvent;

public final class UnitMeasure  extends AggregateRoot {

	private final UnitMeasureId id;
	
	private final BackofficeGroceryId groceryId;
	
	private final UnitMeasureName name;
	
	private final UnitMeasurePrefix prefix;
	
	public UnitMeasure(UnitMeasureId id, BackofficeGroceryId groceryId,UnitMeasureName name,UnitMeasurePrefix prefix) {
	
		this.id = id;
		this.groceryId = groceryId;
		this.name = name;
		this.prefix = prefix;
	}
	
	public UnitMeasure() {
		this.id = null;
		this.groceryId = null;
		this.name = null;
		this.prefix = null;
	}
	
	public static UnitMeasure create(UnitMeasureId id,BackofficeGroceryId groceryId, UnitMeasureName name,UnitMeasurePrefix prefix) {
		
		UnitMeasure unitMeasure = new  UnitMeasure(id,groceryId,name,prefix);
		
		unitMeasure.record(new UnitMeasureCreatedDomainEvent(id.value(), name.value(), prefix.value()));
		
		return unitMeasure;
		
	}
	
	public UnitMeasureId id() {
		
		return id;
	}
	public UnitMeasureName name() {
		return name;
	}
	public UnitMeasurePrefix prefix() {
		return prefix;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UnitMeasure unitMeasure = (UnitMeasure) o;
        return id.equals(unitMeasure.id) &&
               name.equals(unitMeasure.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
