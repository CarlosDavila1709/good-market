package store.market.administration.product.domain;

import java.util.Objects;

import store.market.shared.domain.AggregateRoot;
import store.market.shared.domain.product.ProductCreatedDomainEvent;

public final class Product extends AggregateRoot{

	private final ProductId id;
	
	private final ProductCategorieId categorieId;
	
	private final ProductUnitMeasureId unitMeasureId;
	
	private final ProductName name;
	
	private final ProductPrice price;
	
	public Product(ProductId id, 
			ProductCategorieId categorieId, 
			ProductUnitMeasureId unitMeasureId, 
			ProductName name,
			ProductPrice price) {
		
		this.id = id;
		this.categorieId = categorieId;
		this.unitMeasureId = unitMeasureId;
		this.name = name;
		this.price = price;
	}
	public Product() {
		
		this.id = null;
		this.categorieId = null;
		this.unitMeasureId = null;
		this.name = null;
		this.price = null;
	}
	public static Product create(ProductId id, ProductCategorieId categorieId, ProductUnitMeasureId unitMeasureId, ProductName name, ProductPrice price) {
		
		Product product = new Product(id, categorieId, unitMeasureId, name, price);
		
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
        return Objects.hash(id, categorieId,unitMeasureId,name,price);
    }
}
