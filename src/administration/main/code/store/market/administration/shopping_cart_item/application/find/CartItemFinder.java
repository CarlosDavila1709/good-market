package store.market.administration.shopping_cart_item.application.find;

import store.market.administration.shopping_cart_item.application.CartItemResponse;
import store.market.administration.shopping_cart_item.domain.CartItemId;
import store.market.administration.shopping_cart_item.domain.CartItemNotExist;
import store.market.administration.shopping_cart_item.domain.ItemCartRepository;
import store.market.shared.domain.Service;

@Service
public final class CartItemFinder {

    private final ItemCartRepository repository;

    public CartItemFinder(ItemCartRepository repository) {
        this.repository = repository;
    }

    public CartItemResponse find(CartItemId id) throws CartItemNotExist {
        return repository.search(id)
                         .map(CartItemResponse::fromAggregate)
                         .orElseThrow(() -> new CartItemNotExist(id));
    }
}
