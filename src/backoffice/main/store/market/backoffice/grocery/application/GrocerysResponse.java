package store.market.backoffice.grocery.application;

import store.market.shared.domain.bus.query.Response;

import java.util.List;

public final class GrocerysResponse implements Response{

	private final List<GroceryResponse> grocerys;
	
    public GrocerysResponse(List<GroceryResponse> grocerys) {
        this.grocerys = grocerys;
    }

    public List<GroceryResponse> grocerys() {
        return grocerys;
    }
}
