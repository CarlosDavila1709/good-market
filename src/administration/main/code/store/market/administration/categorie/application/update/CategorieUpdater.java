package store.market.administration.categorie.application.update;

import store.market.administration.categorie.domain.Categorie;
import store.market.administration.categorie.domain.CategorieId;
import store.market.administration.categorie.domain.CategorieName;
import store.market.administration.categorie.domain.CategorieNotExist;
import store.market.administration.categorie.domain.CategorieRepository;
import store.market.shared.domain.Service;

@Service
public final class CategorieUpdater {

	private CategorieRepository repository;
	
	public CategorieUpdater(CategorieRepository repository) {
		
		this.repository = repository;
	}
	
	public void update (CategorieId id, CategorieName name) {
		
		Categorie categorie = repository.search(id).orElseThrow(()-> new CategorieNotExist(id));
		categorie.updateName(name);
		repository.save(categorie);
	}
}
