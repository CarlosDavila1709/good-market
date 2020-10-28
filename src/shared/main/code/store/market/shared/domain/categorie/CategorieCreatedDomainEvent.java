package store.market.shared.domain.categorie;

import java.io.Serializable;
import java.util.HashMap;

import store.market.shared.domain.bus.event.DomainEvent;

public final class CategorieCreatedDomainEvent extends DomainEvent{

	private final String name;
	
	public CategorieCreatedDomainEvent() {
		
		super(null);
		this.name = null;

	}
	
	public CategorieCreatedDomainEvent(String aggregateId, String name) {
		
		super(aggregateId);
		this.name = name;

	}
	
	public CategorieCreatedDomainEvent(String aggregateId,
			String eventId,
			String occurredOn, 
			String name) {
		
		super(aggregateId,eventId,occurredOn);
		this.name = name;		
	}
	
	
    @Override
    public String eventName() {
        return "categorie.created";
    }
    
    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("name", name);
        }};
    }
    
    @Override
    public CategorieCreatedDomainEvent fromPrimitives(
        String aggregateId,
        HashMap<String, Serializable> body,
        String eventId,
        String occurredOn
    ) {
    return new CategorieCreatedDomainEvent(
            aggregateId,
            eventId,
            occurredOn,
            (String) body.get("name")
        );
    }
    
    public String name() {
    	
    	return name;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CategorieCreatedDomainEvent that = (CategorieCreatedDomainEvent) o;
        return name.equals(that.name) ;
    }
}
