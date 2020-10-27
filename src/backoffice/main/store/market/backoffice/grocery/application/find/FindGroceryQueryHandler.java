package store.market.backoffice.grocery.application.find;

import store.market.backoffice.grocery.application.GroceryResponse;
import store.market.backoffice.grocery.domain.GroceryId;
import store.market.backoffice.grocery.domain.GroceryNotExist;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.query.QueryHandler;

@Service
public final class FindGroceryQueryHandler implements QueryHandler<FindGroceryQuery, GroceryResponse> {

    private final GroceryFinder finder;
 
    public FindGroceryQueryHandler(GroceryFinder finder) {
    	
    	this.finder = finder;
    }
 
    @Override
    public GroceryResponse handle(FindGroceryQuery query) throws GroceryNotExist {
        return finder.find(new GroceryId(query.id()));
    }
}
