package store.market.shared.domain.shopping_cart_item;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

import store.market.shared.domain.bus.event.DomainEvent;

public final class DeleteItemToShoppingCartAggregateDomainEvent extends DomainEvent{

	private final String  shoppingCartId;
	private final String  itemProductId;
	
	public DeleteItemToShoppingCartAggregateDomainEvent() {
		this.shoppingCartId = null; 
		this.itemProductId  = null;
	}
	public DeleteItemToShoppingCartAggregateDomainEvent(String aggregateId,String shoppingCartId,String itemProductId) {
		super(aggregateId);
		this.shoppingCartId = shoppingCartId;
		this.itemProductId  = itemProductId;
	}
	
	public DeleteItemToShoppingCartAggregateDomainEvent(String aggregateId,
			String eventId,
			String occurredOn,
		    String shoppingCartId,
		    String itemProductId) {
		
		super(aggregateId,eventId,occurredOn);
		this.shoppingCartId = shoppingCartId;
		this.itemProductId  = itemProductId;
	}
    @Override
    public String eventName() {
        return "deleteItemShoppingcart.aggregate";
    }
    
    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
        	put("shoppingCartId", shoppingCartId);
        	put("itemProductId", itemProductId);
        }};
    }
    @Override
    public DeleteItemToShoppingCartAggregateDomainEvent fromPrimitives(
        String aggregateId,
        HashMap<String, Serializable> body,
        String eventId,
        String occurredOn
    ) {
    return new DeleteItemToShoppingCartAggregateDomainEvent(
            aggregateId,
            eventId,
            occurredOn,
            (String)  body.get("shoppingCartId"),
            (String)  body.get("itemProductId")
        );
    }
    
    public String shoppingCartId() {
    	return shoppingCartId;
    }
    public String itemProductId() {
    	return itemProductId;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DeleteItemToShoppingCartAggregateDomainEvent that = (DeleteItemToShoppingCartAggregateDomainEvent) o;
        return shoppingCartId.equals(that.shoppingCartId) &&
        		itemProductId.endsWith(that.itemProductId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shoppingCartId,itemProductId);
    }

}
