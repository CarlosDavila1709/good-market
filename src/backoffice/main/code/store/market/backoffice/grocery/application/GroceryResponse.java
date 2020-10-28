package store.market.backoffice.grocery.application;

import store.market.backoffice.grocery.domain.Grocery;
import store.market.shared.domain.bus.query.Response;

public final class GroceryResponse implements Response{

	private String id;
	private String nameCommercial;
	private String address;
	private String active;
	
	public GroceryResponse(String id, String nameCommercial, String address, String active) {
        this.id       = id;
        this.nameCommercial     = nameCommercial;
        this.address = address;
        this.active = active;
    }

	public static GroceryResponse fromAggregate(Grocery grocery) {
		
		return new GroceryResponse(grocery.id().value(),grocery.nameCommercial().value(),grocery.address().value(),grocery.active().value());
	}
	
    public String id() {
        return id;
    }

    public String nameCommercial() {
        return nameCommercial;
    }

    public String address() {
        return address;
    }
    public String active() {
        return active;
    }
}
