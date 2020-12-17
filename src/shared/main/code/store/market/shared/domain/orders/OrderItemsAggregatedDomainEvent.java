package store.market.shared.domain.orders;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

import store.market.shared.domain.bus.event.DomainEvent;

public final class OrderItemsAggregatedDomainEvent extends DomainEvent{

	private final String productId;
	private final Integer quantity;
	
	
	public OrderItemsAggregatedDomainEvent() {
		
		super(null);
		this.productId = null;
		this.quantity = 0;

	}
	
	public OrderItemsAggregatedDomainEvent(String aggregateId,String productId,Integer quantity) 
	{
		super(aggregateId);
		this.productId = productId;
		this.quantity = quantity;
	}
	public OrderItemsAggregatedDomainEvent(String aggregateId,
			String eventId,
			String occurredOn,
			String productId,
			int quantity) {
		
		super(aggregateId,eventId,occurredOn);
		this.productId = productId;
		this.quantity  = quantity;
		
	}
    @Override
    public String eventName() {
        return "producttoorder.aggregate";
    }
    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("productId", productId);
            put("quantity", quantity);
        }};
    }
    @Override
    public OrderItemsAggregatedDomainEvent fromPrimitives(
        String aggregateId,
        HashMap<String, Serializable> body,
        String eventId,
        String occurredOn
    ) {
    return new OrderItemsAggregatedDomainEvent(
            aggregateId,
            eventId,
            occurredOn,
            (String)  body.get("productId"),
            (Integer) body.get("quantity")
        );
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
        OrderItemsAggregatedDomainEvent that = (OrderItemsAggregatedDomainEvent) o;
        return productId.equals(that.productId) &&
        		quantity.equals(that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId,quantity);
    }
}
