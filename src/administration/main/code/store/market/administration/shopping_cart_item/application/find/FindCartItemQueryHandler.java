package store.market.administration.shopping_cart_item.application.find;

import store.market.administration.shopping_cart_item.application.CartItemResponse;
import store.market.administration.shopping_cart_item.domain.CartItemId;
import store.market.administration.shopping_cart_item.domain.CartItemNotExist;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.query.QueryHandler;

@Service
public final class FindCartItemQueryHandler implements QueryHandler<FindCartItemQuery, CartItemResponse>{

    private final CartItemFinder finder;

    public FindCartItemQueryHandler(CartItemFinder finder) {
        this.finder = finder;
    }

    @Override
    public CartItemResponse handle(FindCartItemQuery query) throws CartItemNotExist {
        return finder.find(new CartItemId(query.id()));
    }
}
