package store.market.backoffice.grocery.application.search;

import store.market.backoffice.grocery.application.GroceryResponse;
import store.market.backoffice.grocery.domain.GroceryId;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.query.QueryHandler;

@Service
public final class SearchGroceryQueryHandler implements QueryHandler<SearchGroceryQuery, GroceryResponse>{

    private final GrocerySearcher searcher;
    
    public SearchGroceryQueryHandler(GrocerySearcher searcher) {
    	
    	this.searcher = searcher;
    }
 
    @Override
    public GroceryResponse handle(SearchGroceryQuery query)  {
    	GroceryId  groceryId = new GroceryId(query.id());
    	return searcher.search(groceryId);
    }
}
