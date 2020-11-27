package store.market.shared.domain.product;

import java.io.Serializable;
import java.util.HashMap;

import store.market.shared.domain.bus.event.DomainEvent;

public final class ProductDeletedAggregateDomainEvent extends DomainEvent{

	private final String name;
	
	public ProductDeletedAggregateDomainEvent() {
		super(null);
		this.name = null;
	}
	public ProductDeletedAggregateDomainEvent(String aggregateId,  String name) 
	{
		super(aggregateId);
		this.name = name;
	}
	public ProductDeletedAggregateDomainEvent(String aggregateId,
			String eventId,
			String occurredOn, 
			String name) {
		
		super(aggregateId,eventId,occurredOn);
		this.name = name;

	}
    @Override
    public String eventName() {
        return "product.deleted";
    }
    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("name", name);

        }};
    }
    @Override
    public ProductDeletedAggregateDomainEvent fromPrimitives(
        String aggregateId,
        HashMap<String, Serializable> body,
        String eventId,
        String occurredOn
    ) {
    return new ProductDeletedAggregateDomainEvent(
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
        ProductDeletedAggregateDomainEvent that = (ProductDeletedAggregateDomainEvent) o;
        return name.equals(that.name) ;
    }
}
