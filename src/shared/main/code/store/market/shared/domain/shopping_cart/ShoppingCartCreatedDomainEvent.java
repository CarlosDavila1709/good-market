package store.market.shared.domain.shopping_cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

import store.market.shared.domain.bus.event.DomainEvent;

public final class ShoppingCartCreatedDomainEvent extends DomainEvent{

	private final String shoppingCartSessionId;
	
	public ShoppingCartCreatedDomainEvent() {
		
		super(null);
		this.shoppingCartSessionId = null;

	}
	public ShoppingCartCreatedDomainEvent(String aggregateId,String shoppingCartSessionId) 
	{
		super(aggregateId);
		this.shoppingCartSessionId = shoppingCartSessionId;
	}
	public ShoppingCartCreatedDomainEvent(String aggregateId,
			String eventId,
			String occurredOn,
			String shoppingCartSessionId) {
		
		super(aggregateId,eventId,occurredOn);
		this.shoppingCartSessionId = shoppingCartSessionId;
		
	}
	
	
    @Override
    public String eventName() {
        return "shoppingcart.created";
    }
    
    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("shoppingCartSessionId", shoppingCartSessionId);
        }};
    }
    
    @Override
    public ShoppingCartCreatedDomainEvent fromPrimitives(
        String aggregateId,
        HashMap<String, Serializable> body,
        String eventId,
        String occurredOn
    ) {
    return new ShoppingCartCreatedDomainEvent(
            aggregateId,
            eventId,
            occurredOn,
            (String) body.get("shoppingCartSessionId")
        );
    }
    
    public String shoppingCartSessionId() {
        return shoppingCartSessionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ShoppingCartCreatedDomainEvent that = (ShoppingCartCreatedDomainEvent) o;
        return shoppingCartSessionId.equals(that.shoppingCartSessionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shoppingCartSessionId);
    }
}
