package store.market.administration.order.application;

import java.util.List;

import store.market.shared.domain.bus.query.Response;

public final class OrdersResponse implements Response{

    private final List<OrderResponse> orders;
    
    public OrdersResponse(List<OrderResponse> orders) {
       
    	this.orders = orders;
    }

    public List<OrderResponse> orders() {
        return orders;
    }
}
