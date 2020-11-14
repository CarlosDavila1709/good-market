package store.market.shared.domain.orders;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

import store.market.shared.domain.bus.event.DomainEvent;

public final class OrderCreatedDomainEvent extends DomainEvent{

	private String sessionId;
	private String cartId;

	public OrderCreatedDomainEvent() {
		super(null);
        this.sessionId     = null;
        this.cartId		   = null;
	}
	public OrderCreatedDomainEvent(String aggregateId,String sessionId,String cartId) 
	{
		super(aggregateId);

        this.sessionId     = sessionId;
        this.cartId		   = cartId;
		
	}
	public OrderCreatedDomainEvent(
			String aggregateId,
			String eventId,
			String occurredOn,
			String sessionId,
			String cartId) {
		
		super(aggregateId,eventId,occurredOn);
        this.sessionId     = sessionId;
		this.cartId		   = cartId;
	}
	
    @Override
    public String eventName() {
        return "orders.created";
    }
    
    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("sessionId", sessionId);
            put("cartId", cartId); 
        }};
    }
    
    @Override
    public OrderCreatedDomainEvent fromPrimitives(
        String aggregateId,
        HashMap<String, Serializable> body,
        String eventId,
        String occurredOn
    ) {
        return new OrderCreatedDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("sessionId"),
                (String) body.get("cartId")
            );
    }
    
    public String sessionId() {
        return sessionId;
    }
    public String cartId() {
        return cartId;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderCreatedDomainEvent that = (OrderCreatedDomainEvent) o;
        return sessionId.equals(that.sessionId) &&
        		cartId.equals(that.cartId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessionId,cartId);
    }
}
