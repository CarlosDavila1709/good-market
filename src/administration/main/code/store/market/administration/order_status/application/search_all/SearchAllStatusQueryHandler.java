package store.market.administration.order_status.application.search_all;

import store.market.administration.order_status.application.StatusOrdersResponse;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.query.QueryHandler;

@Service
public final class SearchAllStatusQueryHandler implements QueryHandler<SearchAllStatusQuery,StatusOrdersResponse>{

    private final AllStatusSearcher searcher;
    
    public SearchAllStatusQueryHandler(AllStatusSearcher searcher) {
    	
    	this.searcher = searcher;
    }
    
    @Override
    public StatusOrdersResponse handle(SearchAllStatusQuery query) {
        return searcher.search();
    }
}
