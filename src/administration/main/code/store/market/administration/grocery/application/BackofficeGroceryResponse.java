package store.market.administration.grocery.application;

import store.market.administration.grocery.domain.BackofficeGrocery;
import store.market.shared.domain.bus.query.Response;

public final class BackofficeGroceryResponse implements Response{

    private final String id;
    private final String nameCommercial;
    private final String address;
    private final String active;
    
    public BackofficeGroceryResponse(String id, String nameCommercial, String address, String active) {
    	
    	this.id = id;
    	this.nameCommercial = nameCommercial;
    	this.address = address;
    	this.active = active;
    }
    
    public static BackofficeGroceryResponse fromAggregate(BackofficeGrocery grocery) {
        return new BackofficeGroceryResponse(grocery.id(), grocery.nameCommercial(), grocery.address(),grocery.active());
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
