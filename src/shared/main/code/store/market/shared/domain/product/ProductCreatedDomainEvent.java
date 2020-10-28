package store.market.shared.domain.product;

import java.io.Serializable;
import java.util.HashMap;

import store.market.shared.domain.bus.event.DomainEvent;

public final class ProductCreatedDomainEvent extends DomainEvent{

	private final String categorieId;
	
	private final String unitMeasureId;
	
	private final String name;
	
	private final Double price;
	
	public ProductCreatedDomainEvent() {
		
		super(null);
		this.categorieId = null;
		this.unitMeasureId = null;
		this.name = null;
		this.price = null;
	}
	public ProductCreatedDomainEvent(String aggregateId, String categorieId,String unitMeasureId, String name, Double price) 
	{
		super(aggregateId);
		this.categorieId = categorieId;
		this.unitMeasureId = unitMeasureId;
		this.name = name;
		this.price = price;
	}
	public ProductCreatedDomainEvent(String aggregateId,
			String eventId,
			String occurredOn, 
			String categorieId,
			String unitMeasureId, 
			String name,
			Double price) {
		
		super(aggregateId,eventId,occurredOn);
		this.categorieId = categorieId;
		this.unitMeasureId = unitMeasureId;
		this.name = name;
		this.price = price;
		
	}
	
    @Override
    public String eventName() {
        return "product.created";
    }
    
    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("categorieId", categorieId);
            put("unitMeasureId", unitMeasureId);
            put("name", name);
            put("price", price);
        }};
    }
    
    @Override
    public ProductCreatedDomainEvent fromPrimitives(
        String aggregateId,
        HashMap<String, Serializable> body,
        String eventId,
        String occurredOn
    ) {
    return new ProductCreatedDomainEvent(
            aggregateId,
            eventId,
            occurredOn,
            (String) body.get("categorieId"),
            (String) body.get("unitMeasureId"),
            (String) body.get("name"),
            (Double) body.get("price")
        );
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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductCreatedDomainEvent that = (ProductCreatedDomainEvent) o;
        return name.equals(that.name) ;
    }
}
