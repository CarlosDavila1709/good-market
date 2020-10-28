package store.market.administration.product.application.create;

import store.market.shared.domain.bus.command.Command;

public final class CreateProductCommand implements Command {

    private final String id;
    private final String categorieId;
    private final String unitMeasureId;
    private final String name;
    private final Double price;
    
    public CreateProductCommand(String id, String categorieId, String unitMeasureId, String name, Double price) {
        this.id       		= id;
        this.categorieId    = categorieId;
        this.unitMeasureId 	= unitMeasureId;
        this.name 			= name;
        this.price 			= price;
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
