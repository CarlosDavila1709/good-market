package store.market.backoffice.grocery.application.search;

import store.market.backoffice.grocery.application.GroceryResponse;
import store.market.backoffice.grocery.domain.GroceryId;
import store.market.backoffice.grocery.domain.GroceryRepository;
import store.market.shared.domain.Service;

@Service
public final class GrocerySearcher {

	private final GroceryRepository repository;
	
	public GrocerySearcher(GroceryRepository repository) {
		
		this.repository = repository;
	}
	
	public GroceryResponse search(GroceryId id) {

		return repository.search(id)
                .map(GroceryResponse::fromAggregate)
                .orElseGet(() -> null);
	}
}
