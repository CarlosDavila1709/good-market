package store.market.administration.product.application;

import java.util.List;

import store.market.shared.domain.bus.query.Response;

public final class ProductsResponse implements Response{

    private final List<ProductResponse> products;

    public ProductsResponse(List<ProductResponse> products) {
        this.products = products;
    }

    public List<ProductResponse> products() {
        return products;
    }
    
}
