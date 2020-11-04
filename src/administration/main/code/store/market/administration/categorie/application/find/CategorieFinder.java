package store.market.administration.categorie.application.find;

import store.market.administration.categorie.application.CategorieResponse;
import store.market.administration.categorie.domain.CategorieId;
import store.market.administration.categorie.domain.CategorieNotExist;
import store.market.administration.categorie.domain.CategorieRepository;
import store.market.administration.product.domain.ProductNotExist;
import store.market.shared.domain.Service;

@Service
public final class CategorieFinder {

    private final CategorieRepository repository;

    public CategorieFinder(CategorieRepository repository) {
        
    	this.repository = repository;
    }

    public CategorieResponse find(CategorieId id) throws ProductNotExist {
        return repository.search(id)
                         .map(CategorieResponse::fromAggregate)
                         .orElseThrow(() -> new CategorieNotExist(id));
    }
}
