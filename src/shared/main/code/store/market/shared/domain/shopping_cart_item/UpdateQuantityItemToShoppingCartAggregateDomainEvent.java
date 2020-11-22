package store.market.shared.domain.shopping_cart_item;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

import store.market.shared.domain.bus.event.DomainEvent;

public class UpdateQuantityItemToShoppingCartAggregateDomainEvent extends DomainEvent{
	private final String  shoppingCartId;
	private final String  productId;
	private final Integer quantity;

	public UpdateQuantityItemToShoppingCartAggregateDomainEvent() {
		this.shoppingCartId = null; 
		this.productId = null;
		this.quantity = 0;
	}
	
	public UpdateQuantityItemToShoppingCartAggregateDomainEvent(String aggregateId,String shoppingCartId,String productId, Integer quantity) {
		super(aggregateId);
		this.shoppingCartId = shoppingCartId;
		this.productId = productId;
		this.quantity = quantity;
	}
	
	public UpdateQuantityItemToShoppingCartAggregateDomainEvent(String aggregateId,
			String eventId,
			String occurredOn,
		    String shoppingCartId,
		    String productId,
			int quantity) {
		
		super(aggregateId,eventId,occurredOn);
		this.shoppingCartId = shoppingCartId;
		this.productId = productId;
		this.quantity  = quantity;
	}
	
	
    @Override
    public String eventName() {
        return "updateQuantityShoppingcart.aggregate";
    }
    
    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
        	put("shoppingCartId", shoppingCartId);
        	put("productId", productId);
            put("quantity", quantity);
        }};
    }
    
    @Override
    public UpdateQuantityItemToShoppingCartAggregateDomainEvent fromPrimitives(
        String aggregateId,
        HashMap<String, Serializable> body,
        String eventId,
        String occurredOn
    ) {
    return new UpdateQuantityItemToShoppingCartAggregateDomainEvent(
            aggregateId,
            eventId,
            occurredOn,
            (String)  body.get("shoppingCartId"),
            (String)  body.get("productId"),
            (Integer) body.get("quantity")
        );
    }
    
    public String shoppingCartId() {
        return shoppingCartId;
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
        UpdateQuantityItemToShoppingCartAggregateDomainEvent that = (UpdateQuantityItemToShoppingCartAggregateDomainEvent) o;
        return shoppingCartId.equals(that.shoppingCartId) &&
        		productId.equals(that.productId) && 
        		quantity.equals(that.quantity) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(shoppingCartId,productId,quantity);
    }
}
