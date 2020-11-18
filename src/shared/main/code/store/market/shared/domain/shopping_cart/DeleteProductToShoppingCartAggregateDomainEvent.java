package store.market.shared.domain.shopping_cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

import store.market.shared.domain.bus.event.DomainEvent;

public final class DeleteProductToShoppingCartAggregateDomainEvent extends DomainEvent{

	private final String productId;
	private final String sessionId;
	
	public DeleteProductToShoppingCartAggregateDomainEvent() {
		super(null);
		this.productId = null;
		this.sessionId = null;
	}
	public DeleteProductToShoppingCartAggregateDomainEvent(String aggregateId,String sessionId,String productId) 
	{
		super(aggregateId);
		this.sessionId = sessionId;
		this.productId = productId;

	}
	
	public DeleteProductToShoppingCartAggregateDomainEvent(String aggregateId,
			String eventId,
			String occurredOn,
		    String sessionId,
			String productId) {
		
		super(aggregateId,eventId,occurredOn);
		this.sessionId = sessionId;
		this.productId = productId;
		
	}
	
    @Override
    public String eventName() {
        return "deleteproducttoshoppingcart.aggregate";
    }
    
    
    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
        	put("sessionId", sessionId);
            put("productId", productId);
        }};
    }
    public String sessionId() {
        return sessionId;
    }
    
    public String productId() {
        return productId;
    }

    @Override
    public DeleteProductToShoppingCartAggregateDomainEvent fromPrimitives(
        String aggregateId,
        HashMap<String, Serializable> body,
        String eventId,
        String occurredOn
    ) {
    return new DeleteProductToShoppingCartAggregateDomainEvent(
            aggregateId,
            eventId,
            occurredOn,
            (String)  body.get("sessionId"),
            (String)  body.get("productId")
        );
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DeleteProductToShoppingCartAggregateDomainEvent that = (DeleteProductToShoppingCartAggregateDomainEvent) o;
        return productId.equals(that.productId) &&
        		sessionId.equals(that.sessionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessionId,productId);
    }

}
