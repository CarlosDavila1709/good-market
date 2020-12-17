package store.market.shared.domain.orders;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

import store.market.shared.domain.bus.event.DomainEvent;

public final class DeleteItemToOrderAggregateDomainEvent extends DomainEvent{

	private String itemId;
	
	public DeleteItemToOrderAggregateDomainEvent() {
		super(null);
        this.itemId     = null;
	}
	public DeleteItemToOrderAggregateDomainEvent(String aggregateId,String itemId) 
	{
		super(aggregateId);

        this.itemId     = itemId;
		
	}
	public DeleteItemToOrderAggregateDomainEvent(
			String aggregateId,
			String eventId,
			String occurredOn,
			String itemId) {
		
		super(aggregateId,eventId,occurredOn);
		this.itemId		   = itemId;
	}
    @Override
    public String eventName() {
        return "ordersitems.deleted";
    }
    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("itemId", itemId); 
        }};
    }
    
    @Override
    public DeleteItemToOrderAggregateDomainEvent fromPrimitives(
        String aggregateId,
        HashMap<String, Serializable> body,
        String eventId,
        String occurredOn
    ) {
        return new DeleteItemToOrderAggregateDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("itemId")
            );
    }
    public String itemId() {
        return itemId;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DeleteItemToOrderAggregateDomainEvent that = (DeleteItemToOrderAggregateDomainEvent) o;
        return itemId.equals(that.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId);
    }
}
