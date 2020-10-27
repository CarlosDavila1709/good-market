package store.market.administration.categorie.application.search_all;

import java.util.stream.Collectors;

import store.market.administration.categorie.application.CategorieResponse;
import store.market.administration.categorie.application.CategoriesResponse;
import store.market.administration.categorie.domain.CategorieRepository;
import store.market.shared.domain.Service;

@Service
public final class AllCategoriesSearch {

	private final CategorieRepository repository;
	
	public AllCategoriesSearch(CategorieRepository repository) {
		
		this.repository = repository;
	}
	
	public CategoriesResponse search() {
		
		return new CategoriesResponse(
				repository.searchAll().stream().map(CategorieResponse::fromAggregate).collect(Collectors.toList())
		);
	}
}
