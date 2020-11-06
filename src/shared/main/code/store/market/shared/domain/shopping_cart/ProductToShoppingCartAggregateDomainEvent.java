package store.market.shared.domain.shopping_cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

import store.market.shared.domain.bus.event.DomainEvent;

public final class ProductToShoppingCartAggregateDomainEvent extends DomainEvent{
	
	private final String productId;
	private final String sessionId;
	private final Integer quantity;
	
	public ProductToShoppingCartAggregateDomainEvent() {
		
		super(null);
		this.productId = null;
		this.sessionId = null;
		this.quantity = 0;

	}
	public ProductToShoppingCartAggregateDomainEvent(String aggregateId,String sessionId,String productId,Integer quantity) 
	{
		super(aggregateId);
		this.sessionId = sessionId;
		this.productId = productId;
		this.quantity = quantity;
	}
	public ProductToShoppingCartAggregateDomainEvent(String aggregateId,
			String eventId,
			String occurredOn,
		    String sessionId,
			String productId,
			int quantity) {
		
		super(aggregateId,eventId,occurredOn);
		this.sessionId = sessionId;
		this.productId = productId;
		this.quantity = quantity;
		
	}
	
	
    @Override
    public String eventName() {
        return "producttoshoppingcart.aggregate";
    }
    
    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
        	put("sessionId", sessionId);
            put("productId", productId);
            put("quantity", quantity);
        }};
    }
    
    @Override
    public ProductToShoppingCartAggregateDomainEvent fromPrimitives(
        String aggregateId,
        HashMap<String, Serializable> body,
        String eventId,
        String occurredOn
    ) {
    return new ProductToShoppingCartAggregateDomainEvent(
            aggregateId,
            eventId,
            occurredOn,
            (String) body.get("sessionId"),
            (String) body.get("productId"),
            (Integer) body.get("quantity")
        );
    }
    
    public String sessionId() {
        return sessionId;
    }
    
    public String productId() {
        return productId;
    }

    
    public Integer quantity() {
        return quantity;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductToShoppingCartAggregateDomainEvent that = (ProductToShoppingCartAggregateDomainEvent) o;
        return productId.equals(that.productId) &&
        		sessionId.equals(that.sessionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessionId,productId,quantity);
    }

}
