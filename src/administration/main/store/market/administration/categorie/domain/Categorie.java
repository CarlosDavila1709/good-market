package store.market.administration.categorie.domain;

import store.market.shared.domain.AggregateRoot;

public final class Categorie extends AggregateRoot {

	private final CategorieId id;
	
	private final CategorieName name;
	
	
	public Categorie(CategorieId id, CategorieName name) {
		this.id = id;
		this.name = name;
	}
	
	public Categorie() {
		this.id = null;
		this.name = null;
	}
	
	public static Categorie create(CategorieId id, CategorieName name) {
		
		Categorie categorie = new Categorie(id, name);
		
		//categorie.record(event);
		
		return categorie;
	}
	
}
