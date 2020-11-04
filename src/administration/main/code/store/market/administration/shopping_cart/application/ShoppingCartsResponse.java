package store.market.administration.shopping_cart.application;

import java.util.List;

import store.market.shared.domain.bus.query.Response;

public final class ShoppingCartsResponse implements Response{

    private final List<ShoppingCartResponse> carts;

    public ShoppingCartsResponse(List<ShoppingCartResponse> carts) {
        this.carts = carts;
    }

    public List<ShoppingCartResponse> carts() {
        return carts;
    }
}
