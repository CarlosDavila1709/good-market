package store.market.shared.domain.product;

import java.io.Serializable;
import java.util.HashMap;

import store.market.shared.domain.bus.event.DomainEvent;

public final class ProductUpdatedDomainEvent extends DomainEvent{

	private final Double price;
	
	public ProductUpdatedDomainEvent() {
		
		super(null);
		this.price = null;
	}
	public ProductUpdatedDomainEvent(String aggregateId, Double price) 
	{
		super(aggregateId);
		this.price = price;
	}
	public ProductUpdatedDomainEvent(String aggregateId,
			String eventId,
			String occurredOn, 
			Double price) {
		
		super(aggregateId,eventId,occurredOn);
		this.price = price;
		
	}
    @Override
    public String eventName() {
        return "product.updated";
    }
    
    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("price", price);
        }};
    }
    @Override
    public ProductUpdatedDomainEvent fromPrimitives(
        String aggregateId,
        HashMap<String, Serializable> body,
        String eventId,
        String occurredOn
    ) {
    return new ProductUpdatedDomainEvent(
            aggregateId,
            eventId,
            occurredOn,
            (Double) body.get("price")
        );
    }
    
    public Double price() {
        return price;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductUpdatedDomainEvent that = (ProductUpdatedDomainEvent) o;
        return price.equals(that.price) ;
    }
}
