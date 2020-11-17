package store.market.backoffice.grocery.application.search_all;

import store.market.backoffice.grocery.application.GrocerysResponse;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.query.QueryHandler;

@Service
public final class SearchAllGrocerysQueryHandler implements QueryHandler<SearchAllGrocerysQuery, GrocerysResponse>{

    private final AllGrocerysSearcher searcher;

    public SearchAllGrocerysQueryHandler(AllGrocerysSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public GrocerysResponse handle(SearchAllGrocerysQuery query) {
        return searcher.search();
    }
}
