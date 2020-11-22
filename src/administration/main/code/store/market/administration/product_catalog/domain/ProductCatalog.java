package store.market.administration.product_catalog.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class ProductCatalog {

    private final ProductCatalogId id;
    private final String categorieId;
    private final String categorieName;
    private final String unitMeasureId;
    private final String unitMeasureName;
    private final String groceryId;
    private final String name;
    private Double price;
    
    public ProductCatalog() {
        this.id = null;
        this.name = null;
        this.unitMeasureId = null;
        this.unitMeasureName = null;
        this.categorieId = null;
        this.groceryId = null;
        this.categorieName = null;
        this.price = null;
    }
    public ProductCatalog(ProductCatalogId id, 
    		String name, 
    		String categorieId, 
    		String categorieName,
    		String unitMeasureId,
    		String groceryId,
    		String unitMeasureName,
    		Double price) {
        this.id = id;
        this.name = name;
        this.unitMeasureId = unitMeasureId;
        this.unitMeasureName = unitMeasureName;
        this.categorieId = categorieId;
        this.categorieName = categorieName;
        this.price = price;
        this.groceryId = groceryId;
    }
    public static ProductCatalog fromPrimitives(Map<String, Object> plainData) {
        return new ProductCatalog(
            (ProductCatalogId) plainData.get("id"),
            (String) plainData.get("categorieId"),
            (String) plainData.get("categorieName"),
            (String) plainData.get("unitMeasureId"),
            (String) plainData.get("unitMeasureName"),
            (String) plainData.get("groceryId"),
            (String) plainData.get("name"),
            (Double) plainData.get("price")
        );
    }
    public ProductCatalogId id() {
        return id;
    }
    public String categorieId() {
        return categorieId;
    }
    public String categorieName() {
        return categorieName;
    }
    public String unitMeasureId() {
        return unitMeasureId;
    }
    public String unitMeasureName() {
        return unitMeasureName;
    }
    public String groceryId() {
        return groceryId;
    }
    public String name() {
        return name;
    }
    public Double price() {
        return price;
    }
    public void updatePrice(Double price) {
        this.price = price;
    }
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("id", id.value());
            put("name", name);
            put("categorieId", categorieId);
            put("categorieName", categorieName);
            put("unitMeasureId", unitMeasureId);
            put("unitMeasureName", unitMeasureName);
            put("price", price.toString());
            put("groceryId", groceryId);
        }};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductCatalog that = (ProductCatalog) o;
        return id.equals(that.id) &&
               name.equals(that.name) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash( id,  name, categorieId, categorieName, unitMeasureId, groceryId,unitMeasureName, price);
    }
}
