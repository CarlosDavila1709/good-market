package store.market.administration.shopping_cart_item.application;

import java.util.List;

import store.market.shared.domain.bus.query.Response;

public final class CartItemsResponse implements Response{

    private final List<CartItemResponse> items;

    public CartItemsResponse(List<CartItemResponse> items) {
        this.items = items;
    }

    public List<CartItemResponse> items() {
        return items;
    }
}
