package store.market.shared.domain.grocery;

import java.io.Serializable;
import java.util.HashMap;

import store.market.shared.domain.bus.event.DomainEvent;

public final class GroceryCreatedDomainEvent extends DomainEvent{

	private final String nameCommercial;
	private final String address;
	private final String active;
	
	public GroceryCreatedDomainEvent() {
		
		super(null);
		this.nameCommercial = null;
		this.address = null;
		this.active = null;
	}
	public GroceryCreatedDomainEvent(String aggregateId, String nameCommercial,String address, String active) {
		
		super(aggregateId);
		this.nameCommercial = nameCommercial;
		this.address = address;
		this.active = active;
		
	}
	public GroceryCreatedDomainEvent(String aggregateId,
			String eventId,
			String occurredOn, 
			String nameCommercial,
			String address, 
			String active) {
		
		super(aggregateId,eventId,occurredOn);
		this.nameCommercial = nameCommercial;
		this.address = address;
		this.active = active;
		
	}
	
    @Override
    public String eventName() {
        return "grocery.created";
    }
    
    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("nameCommercial", nameCommercial);
            put("address", address);
            put("active", active);
        }};
    }
    
    @Override
    public GroceryCreatedDomainEvent fromPrimitives(
        String aggregateId,
        HashMap<String, Serializable> body,
        String eventId,
        String occurredOn
    ) {
    return new GroceryCreatedDomainEvent(
            aggregateId,
            eventId,
            occurredOn,
            (String) body.get("nameCommercial"),
            (String) body.get("address"),
            (String) body.get("active")
        );
    }
    
    public String nameCommercial() {
        return nameCommercial;
    }

    public String address() {
        return address;
    }
    
    public String active() {
        return active;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GroceryCreatedDomainEvent that = (GroceryCreatedDomainEvent) o;
        return nameCommercial.equals(that.nameCommercial) &&
               address.equals(that.address);
    }
}
