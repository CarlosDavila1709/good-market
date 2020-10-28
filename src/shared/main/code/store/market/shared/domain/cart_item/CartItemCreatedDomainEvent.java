package store.market.shared.domain.cart_item;

import java.io.Serializable;
import java.util.HashMap;

import store.market.shared.domain.bus.event.DomainEvent;

public final class CartItemCreatedDomainEvent extends DomainEvent{


	private final String productName;
	
	public CartItemCreatedDomainEvent() {
		
		super(null);

		this.productName = null;
	}
	public CartItemCreatedDomainEvent(String aggregateId, String productName) 
	{
		super(aggregateId);

		this.productName = productName;

	}
	public CartItemCreatedDomainEvent(String aggregateId,
			String eventId,
			String occurredOn, 
			String productName) {
		
		super(aggregateId,eventId,occurredOn);

		this.productName = productName;
	}
	
    @Override
    public String eventName() {
        return "cartitem.created";
    }
    
    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("productName", productName);
        }};
    }
    @Override
    public CartItemCreatedDomainEvent fromPrimitives(
        String aggregateId,
        HashMap<String, Serializable> body,
        String eventId,
        String occurredOn
    ) {
    return new CartItemCreatedDomainEvent(
            aggregateId,
            eventId,
            occurredOn,
            (String) body.get("productName")
        );
    }

    public String productName() {
    	return productName;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CartItemCreatedDomainEvent that = (CartItemCreatedDomainEvent) o;
        return productName.equals(that.productName) ;
    }
}

