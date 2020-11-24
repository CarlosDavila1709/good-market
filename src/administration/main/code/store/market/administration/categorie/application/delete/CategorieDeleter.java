package store.market.administration.categorie.application.delete;

import store.market.administration.categorie.domain.Categorie;
import store.market.administration.categorie.domain.CategorieId;
import store.market.administration.categorie.domain.CategorieNotExist;
import store.market.administration.categorie.domain.CategorieRepository;
import store.market.shared.domain.Service;

@Service
public final  class CategorieDeleter {

	private CategorieRepository repository;
	
	public CategorieDeleter(CategorieRepository repository) {
		
		this.repository = repository;
	}
	
	public void delete(CategorieId id) {
		Categorie categorie = repository.search(id).orElseThrow(()->{throw new CategorieNotExist(id);});
		repository.delete(categorie);
	}
}
