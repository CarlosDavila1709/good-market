package store.market.administration.order_status.application;

import java.util.List;

import store.market.shared.domain.bus.query.Response;

public final class StatusOrdersResponse implements Response{

    private final List<StatusOrderResponse> statusOrders;
    
    public StatusOrdersResponse(List<StatusOrderResponse> statusOrders) {
       
    	this.statusOrders = statusOrders;
    }

    public List<StatusOrderResponse> statusOrders() {
        return statusOrders;
    }
}
