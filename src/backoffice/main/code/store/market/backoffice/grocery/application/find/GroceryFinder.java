package store.market.backoffice.grocery.application.find;

import store.market.backoffice.grocery.application.GroceryResponse;
import store.market.backoffice.grocery.domain.GroceryId;
import store.market.backoffice.grocery.domain.GroceryNotExist;
import store.market.backoffice.grocery.domain.GroceryRepository;
import store.market.shared.domain.Service;

@Service
public final class GroceryFinder {

	private final GroceryRepository repository;
	
	public GroceryFinder(GroceryRepository repository) {
		
		this.repository = repository;
	}
	
	public GroceryResponse find(GroceryId id) throws GroceryNotExist{
        return repository.search(id)
                .map(GroceryResponse::fromAggregate)
                .orElseThrow(() -> new GroceryNotExist(id));
	}
}
