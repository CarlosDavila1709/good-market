package store.market.backoffice.grocery.application.search_all;

import java.util.stream.Collectors;

import store.market.backoffice.grocery.application.GroceryResponse;
import store.market.backoffice.grocery.application.GrocerysResponse;
import store.market.backoffice.grocery.domain.GroceryRepository;
import store.market.shared.domain.Service;

@Service
public final class AllGrocerysSearcher {
	   
	private final GroceryRepository repository;

    public AllGrocerysSearcher(GroceryRepository repository) {
        this.repository = repository;
    }

    public GrocerysResponse search() {
        return new GrocerysResponse(
            repository.searchAll().stream().map(GroceryResponse::fromAggregate).collect(Collectors.toList())
        );
    }

}
