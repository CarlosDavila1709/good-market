package store.market.administration.categorie.application.search_all;

import store.market.administration.categorie.application.CategoriesResponse;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.query.QueryHandler;

@Service
public final class SearchAllCategoriesQueryHandler implements QueryHandler<SearchAllCategoriesQuery, CategoriesResponse> {

	private final AllCategoriesSearch searcher;
	
    public SearchAllCategoriesQueryHandler(AllCategoriesSearch searcher) {
        this.searcher = searcher;
    }

    @Override
    public CategoriesResponse handle(SearchAllCategoriesQuery query) {
        return searcher.search();
    }
}
