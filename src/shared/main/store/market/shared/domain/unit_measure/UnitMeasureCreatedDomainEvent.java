package store.market.shared.domain.unit_measure;

import java.io.Serializable;
import java.util.HashMap;

import store.market.shared.domain.bus.event.DomainEvent;

public final class UnitMeasureCreatedDomainEvent extends DomainEvent{

	private final String name;
	
	private final String prefix;
	
	public UnitMeasureCreatedDomainEvent() {
		super(null);
		this.name = null;
		this.prefix = null;
	}
	public UnitMeasureCreatedDomainEvent(String aggregateId, String name, String prefix) {
		
		super(aggregateId);
		this.name = name;
		this.prefix = prefix;
	}
	public UnitMeasureCreatedDomainEvent
		(String aggregateId,
				String eventId,
				String occurredOn, 
				String name,
				String prefix) {
		
		
		super(aggregateId,eventId,occurredOn);
		this.name = name;
		this.prefix = prefix;
	}
	
    @Override
    public String eventName() {
        return "unitmeasure.created";
    }
    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("name", name);
            put("prefix", prefix);
        }};
    }
    @Override
    public UnitMeasureCreatedDomainEvent fromPrimitives(
        String aggregateId,
        HashMap<String, Serializable> body,
        String eventId,
        String occurredOn
    ) {
    return new UnitMeasureCreatedDomainEvent(
            aggregateId,
            eventId,
            occurredOn,
            (String) body.get("name"),
            (String) body.get("prefix")
        );
    }
    public String name() {
    	return name;
    }
    public String prefix() {
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
        UnitMeasureCreatedDomainEvent that = (UnitMeasureCreatedDomainEvent) o;
        return name.equals(that.name) ;
    }
}
