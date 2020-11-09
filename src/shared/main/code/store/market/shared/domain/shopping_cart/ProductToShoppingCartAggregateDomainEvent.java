package store.market.shared.domain.shopping_cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

import store.market.shared.domain.bus.event.DomainEvent;

public final class ProductToShoppingCartAggregateDomainEvent extends DomainEvent{
	
	private final String productId;
	private final String sessionId;
	private final String groceryId;
	private final Integer quantity;
	
	public ProductToShoppingCartAggregateDomainEvent() {
		
		super(null);
		this.productId = null;
		this.sessionId = null;
		this.groceryId = null;
		this.quantity = 0;

	}
	public ProductToShoppingCartAggregateDomainEvent(String aggregateId,String sessionId,String productId,Integer quantity,String groceryId) 
	{
		super(aggregateId);
		this.sessionId = sessionId;
		this.productId = productId;
		this.quantity = quantity;
		this.groceryId = groceryId;
	}
	public ProductToShoppingCartAggregateDomainEvent(String aggregateId,
			String eventId,
			String occurredOn,
		    String sessionId,
			String productId,
			int quantity,
			String groceryId) {
		
		super(aggregateId,eventId,occurredOn);
		this.sessionId = sessionId;
		this.productId = productId;
		this.quantity  = quantity;
		this.groceryId = groceryId;
		
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
            put("groceryId", groceryId);
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
            (String)  body.get("sessionId"),
            (String)  body.get("productId"),
            (Integer) body.get("quantity"),
            (String)  body.get("groceryId")
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
    public String groceryId() {
    	return groceryId;
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
        		sessionId.equals(that.sessionId) &&
        		groceryId.equals(that.groceryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessionId,productId,quantity,groceryId);
    }

}
