package store.market.administration.grocery.application.find;

import store.market.administration.grocery.application.BackofficeGroceryResponse;
import store.market.administration.grocery.domain.BackofficeGroceryId;
import store.market.administration.grocery.domain.BackofficeGroceryNotExist;
import store.market.administration.grocery.domain.BackofficeGroceryRepository;
import store.market.shared.domain.Service;

@Service
public final class BackofficeGroceryFinder  {

	private final BackofficeGroceryRepository repository;
	
	public BackofficeGroceryFinder(BackofficeGroceryRepository repository) {
		
		this.repository = repository;
	}
	
    public BackofficeGroceryResponse find(BackofficeGroceryId id) throws BackofficeGroceryNotExist {
        return repository.search(id)
                         .map(BackofficeGroceryResponse::fromAggregate)
                         .orElseThrow(() -> new BackofficeGroceryNotExist(id));
    }
}
