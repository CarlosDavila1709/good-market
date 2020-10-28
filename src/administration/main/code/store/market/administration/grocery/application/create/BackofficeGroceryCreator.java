package store.market.administration.grocery.application.create;

import store.market.administration.grocery.domain.BackofficeGrocery;
import store.market.administration.grocery.domain.BackofficeGroceryRepository;
import store.market.shared.domain.Service;

@Service
public final class BackofficeGroceryCreator {

    private final BackofficeGroceryRepository repository;
    
    public BackofficeGroceryCreator(BackofficeGroceryRepository repository) {
        this.repository = repository;
    }
    
    public void create(String id, String nameCommercial, String address, String active) {
        this.repository.save(new BackofficeGrocery(id, nameCommercial, address, active));
    }
    
}
