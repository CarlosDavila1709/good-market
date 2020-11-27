package store.market.administration.product.domain;

import java.util.Objects;

import store.market.administration.grocery.domain.BackofficeGroceryId;
import store.market.shared.domain.AggregateRoot;
import store.market.shared.domain.product.ProductCreatedDomainEvent;
import store.market.shared.domain.product.ProductDeletedAggregateDomainEvent;
import store.market.shared.domain.product.ProductUpdatedDomainEvent;

public final class Product extends AggregateRoot{

	private final ProductId id;
	
	private final ProductCategorieId categorieId;
	
	private final ProductUnitMeasureId unitMeasureId;
	
	private final BackofficeGroceryId groceryId;
	
	private final ProductName name;
	
	private ProductPrice price;
	
	public Product(ProductId id, 
			ProductCategorieId categorieId, 
			ProductUnitMeasureId unitMeasureId, 
			BackofficeGroceryId groceryId,
			ProductName name,
			ProductPrice price) {
		
		this.id = id;
		this.categorieId = categorieId;
		this.unitMeasureId = unitMeasureId;
		this.groceryId = groceryId;
		this.name = name;
		this.price = price;
	}
	public Product() {
		
		this.id = null;
		this.categorieId = null;
		this.unitMeasureId = null;
		this.groceryId = null;
		this.name = null;
		this.price = null;
	}
	public static Product create(ProductId id, ProductCategorieId categorieId, ProductUnitMeasureId unitMeasureId,BackofficeGroceryId groceryId, ProductName name, ProductPrice price) {
		
		Product product = new Product(id, categorieId, unitMeasureId, groceryId, name, price);
		
		product.record(new ProductCreatedDomainEvent(id.value(), categorieId.value(), unitMeasureId.value(), name.value(), price.value()));
		
		return product;
	}
	
    public ProductId id() {
        return id;
    }

    public ProductName name() {
        return name;
    }

    public ProductCategorieId categorieId() {
        return categorieId;
    }
    public ProductUnitMeasureId unitMeasureId() {
        return unitMeasureId;
    }
    public ProductPrice price() {
        return price;
    }
    public BackofficeGroceryId groceryId() {
        return groceryId;
    }

    public void updatePrice(ProductPrice price) {
        
    	this.price = price;
       
        this.record(new ProductUpdatedDomainEvent(this.id.value(),price.value()));
        
    }
    public void prepareElimination() {
    	this.record(new ProductDeletedAggregateDomainEvent(this.id.value(),this.name.value()));
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return id.equals(product.id) &&
        		name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categorieId,unitMeasureId,groceryId,name,price);
    }
}
