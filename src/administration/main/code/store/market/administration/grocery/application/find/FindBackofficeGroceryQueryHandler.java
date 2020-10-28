package store.market.administration.grocery.application.find;

import store.market.administration.grocery.application.BackofficeGroceryResponse;
import store.market.administration.grocery.domain.BackofficeGroceryId;
import store.market.administration.grocery.domain.BackofficeGroceryNotExist;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.query.QueryHandler;

@Service
public final class FindBackofficeGroceryQueryHandler implements QueryHandler<FindBackofficeGroceryQuery, BackofficeGroceryResponse>{

    private final BackofficeGroceryFinder finder;

    public FindBackofficeGroceryQueryHandler(BackofficeGroceryFinder finder) {
        this.finder = finder;
    }

    @Override
    public BackofficeGroceryResponse handle(FindBackofficeGroceryQuery query) throws BackofficeGroceryNotExist {
        return finder.find(new BackofficeGroceryId(query.id()));
    }
    
}
