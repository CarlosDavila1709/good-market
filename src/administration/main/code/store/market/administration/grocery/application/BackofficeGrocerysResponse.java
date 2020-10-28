package store.market.administration.grocery.application;

import java.util.List;

import store.market.shared.domain.bus.query.Response;

public final class BackofficeGrocerysResponse implements Response{

    private final List<BackofficeGroceryResponse> grocerys;
    
    public BackofficeGrocerysResponse(List<BackofficeGroceryResponse> grocerys) {
       
    	this.grocerys = grocerys;
    }

    public List<BackofficeGroceryResponse> grocerys() {
        return grocerys;
    }
}
