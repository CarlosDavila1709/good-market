package store.market.backoffice.grocery.domain;

import java.util.Objects;

import store.market.shared.domain.AggregateRoot;
import store.market.shared.domain.grocery.GroceryCreatedDomainEvent;

public final class Grocery extends AggregateRoot{

	private final GroceryId id;
	private final GroceryNameCommercial nameCommercial;
	private final GroceryAddress address;
	private final GroceryActive active;
	

	public Grocery(GroceryId id, GroceryNameCommercial nameCommercial, GroceryAddress address,GroceryActive active) {
		this.id=id;
		this.nameCommercial=nameCommercial;
		this.address = address;
		this.active=active;
	}
	private Grocery() {
		this.id=null;
		this.nameCommercial=null;
		this.address = null;
		this.active=null;
	}
	public static Grocery create(GroceryId id, GroceryNameCommercial nameCommercial,GroceryAddress address, GroceryActive active) {
		
		Grocery grocery = new Grocery(id,nameCommercial,address,active);
		
		grocery.record(new GroceryCreatedDomainEvent(id.value(),nameCommercial.value(),address.value(),active.value()));
		
		return grocery;
	}
	
	public GroceryId id() {
		
		return id;
	}
	public GroceryNameCommercial nameCommercial() {
		
		return nameCommercial;
	}
	public GroceryAddress address() {
		
		return address;
	}
	public GroceryActive active() {
		
		return active;
	}
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Grocery grocery = (Grocery) o;
        return id.equals(grocery.id) &&
               nameCommercial.equals(grocery.nameCommercial) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameCommercial,address,active);
    }
}
