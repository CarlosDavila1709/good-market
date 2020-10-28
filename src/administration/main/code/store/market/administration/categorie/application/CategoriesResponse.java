package store.market.administration.categorie.application;

import java.util.List;

import store.market.shared.domain.bus.query.Response;

public final class CategoriesResponse implements Response {

	private final List<CategorieResponse> categories;
	
	public CategoriesResponse(List<CategorieResponse> categories) {
		
		this.categories = categories;
	}
	
	public List<CategorieResponse> categories() {
	    return categories;
	}
}
