package store.market.administration.categorie.application;

import store.market.administration.categorie.domain.Categorie;
import store.market.shared.domain.bus.query.Response;

public final class CategorieResponse implements Response{

	private final String id;
	
	private final String name;
	
	public CategorieResponse(String id, String name) {
		
		this.id = id;
		this.name = name;
	}
	
	public static CategorieResponse fromAggregate(Categorie categorie) {
	
		return new CategorieResponse(categorie.id().value(),categorie.name().value());
	}
	
	public String id() {
		return id;
	}
	
	public String name() {
		return name;
	}
}
