package store.market.administration.shopping_cart_item.domain;

import java.util.List;
import java.util.Optional;

import store.market.shared.domain.criteria.Criteria;

public interface CartItemRepository {

    void save(CartItem cartItem);

    Optional<CartItem> search(CartProductId id);

    List<CartItem> matching(Criteria criteria);
}
