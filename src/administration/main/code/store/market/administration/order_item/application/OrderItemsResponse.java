package store.market.administration.order_item.application;

import java.util.List;

import store.market.shared.domain.bus.query.Response;

public final class OrderItemsResponse  implements Response{
    private final List<OrderItemResponse> items;

    public OrderItemsResponse(List<OrderItemResponse> items) {
        this.items = items;
    }

    public List<OrderItemResponse> items() {
        return items;
    }
}
