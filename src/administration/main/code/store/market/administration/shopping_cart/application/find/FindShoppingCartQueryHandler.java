package store.market.administration.shopping_cart.application.find;

import store.market.administration.shopping_cart.application.ShoppingCartResponse;
import store.market.administration.shopping_cart.domain.ShoppingCartId;
import store.market.administration.shopping_cart.domain.ShoppingCartNotExist;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.query.QueryHandler;

@Service
public class FindShoppingCartQueryHandler implements QueryHandler<FindShoppingCartQuery, ShoppingCartResponse>{

    private final ShoppingCartFinder finder;

    public FindShoppingCartQueryHandler(ShoppingCartFinder finder) {
        this.finder = finder;
    }

    @Override
    public ShoppingCartResponse handle(FindShoppingCartQuery query) throws ShoppingCartNotExist {
        return finder.find(new ShoppingCartId(query.id()));
    }
}
