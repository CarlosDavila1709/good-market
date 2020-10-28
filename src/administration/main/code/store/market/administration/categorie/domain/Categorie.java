package store.market.administration.categorie.domain;

import store.market.shared.domain.AggregateRoot;
import store.market.shared.domain.categorie.CategorieCreatedDomainEvent;

import java.util.Objects;

public final class Categorie extends AggregateRoot {

	private final CategorieId id;
	
	private final BackofficeGroceryId groceryId;
	
	private final CategorieName name;

	public Categorie(CategorieId id, CategorieName name,BackofficeGroceryId groceryId) {
		this.id = id;
		
		this.groceryId = groceryId;
		
		this.name = name;
	}
	
	public Categorie() {
		this.id = null;
		this.name = null;
		this.groceryId = null; 
	}
	
	public static Categorie create(CategorieId id, CategorieName name,BackofficeGroceryId groceryId) {
		
		Categorie categorie = new Categorie(id, name,groceryId);
		
		categorie.record(new CategorieCreatedDomainEvent(id.value(), name.value()));
		
		return categorie;
	}
	
	public CategorieId id() {
		return id;
	}
	public CategorieName name() {
		return name;
	}
	public BackofficeGroceryId groceryId() {
		return groceryId;
	}
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Categorie categorie = (Categorie) o;
        return id.equals(categorie.id) &&
               name.equals(categorie.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
