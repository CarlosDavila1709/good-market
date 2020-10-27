package store.market.administration.product.application;

import store.market.administration.product.domain.Product;
import store.market.shared.domain.bus.query.Response;

public final class ProductResponse implements Response {

    private final String id;
    private final String categorieId;
    private final String unitMeasureId;
    private final String name;
    private final Double price;
    
    public ProductResponse(String id, String categorieId, String unitMeasureId, String name, Double price) {
        this.id       = id;
        this.categorieId     = categorieId;
        this.unitMeasureId = unitMeasureId;
        this.name = name;
        this.price = price;
    }
    public static ProductResponse fromAggregate(Product product) {
        return new ProductResponse(product.id().value(),product.categorieId().value(),product.unitMeasureId().value(),product.name().value(),product.price().value());
    }

    public String id() {
    	return id;
    }
    public String categorieId() {
    	return categorieId;
    }
    public String unitMeasureId() {
    	return unitMeasureId;
    }
    public String name() {
    	return name;
    }
    public Double price() {
    	return price;
    }
}
