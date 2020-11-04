package store.market.administration.shopping_cart.application.find;

import store.market.administration.shopping_cart.application.ShoppingCartResponse;
import store.market.administration.shopping_cart.domain.ShoppingCartId;
import store.market.administration.shopping_cart.domain.ShoppingCartNotExist;
import store.market.administration.shopping_cart.domain.ShoppingCartRepository;
import store.market.shared.domain.Service;

@Service
public final class ShoppingCartFinder {

    private final ShoppingCartRepository repository;

    public ShoppingCartFinder(ShoppingCartRepository repository) {
        this.repository = repository;
    }

    public ShoppingCartResponse find(ShoppingCartId id) throws ShoppingCartNotExist {
        return repository.search(id)
                         .map(ShoppingCartResponse::fromAggregate)
                         .orElseThrow(() -> new ShoppingCartNotExist(id));
    }
}
