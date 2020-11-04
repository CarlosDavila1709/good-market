package store.market.administration.product_catalog.application;

import store.market.administration.product_catalog.domain.ProductCatalog;
import store.market.shared.domain.bus.query.Response;

public final class ProductCatalogResponse implements Response{

    private final String id;
    private final String categorieId;
    private final String categorieName;
    private final String unitMeasureId;
    private final String unitMeasureName;
    private final String name;
    private final Double price;
    
    public ProductCatalogResponse(String id,
    		String categorieId,
    		String categorieName,
    		String unitMeasureId,
    		String unitMeasureName,
    		String name,
    		Double price) {
    	
        this.id = id;
        this.categorieId = categorieId;
        this.categorieName = categorieName;
        this.unitMeasureId = unitMeasureId;
        this.unitMeasureName = unitMeasureName;
        this.name = name;
        this.price = price;
    }
    
    
	public static ProductCatalogResponse fromAggregate(ProductCatalog productCatalog) {
		
		return new ProductCatalogResponse(productCatalog.id().value(),
				productCatalog.categorieId(),
				productCatalog.categorieName(), 
				productCatalog.unitMeasureId(),
				productCatalog.unitMeasureName(),
				productCatalog.name(),
				productCatalog.price());
		
	}
	
	public String id() {
		return id;
	}
	public String categorieId() {
		return categorieId;
	}
	public String categorieName() {
		return categorieName;
	}
	public String name() {
		return name;
	}
	public String unitMeasureId() {
		return unitMeasureId;
	}
	public String unitMeasureName() {
		return unitMeasureName;
	}
	public Double price() {
		return price;
	}
}
