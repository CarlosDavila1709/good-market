package store.market.administration.categorie.application.find;

import store.market.administration.categorie.application.CategorieResponse;
import store.market.administration.categorie.domain.CategorieId;
import store.market.administration.categorie.domain.CategorieNotExist;

import store.market.shared.domain.Service;
import store.market.shared.domain.bus.query.QueryHandler;

@Service
public final class FindCategorieQueryHandler implements QueryHandler<FindCategorieQuery, CategorieResponse>{

    private final CategorieFinder finder;

    public FindCategorieQueryHandler(CategorieFinder finder) {
        this.finder = finder;
    }

    @Override
    public CategorieResponse handle(FindCategorieQuery query) throws CategorieNotExist {
        return finder.find(new CategorieId(query.id()));
    }
}
