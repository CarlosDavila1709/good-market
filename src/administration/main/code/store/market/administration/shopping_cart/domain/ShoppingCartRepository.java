package store.market.administration.shopping_cart.domain;

import java.util.List;
import java.util.Optional;

import store.market.shared.domain.criteria.Criteria;

public interface ShoppingCartRepository {

    void save(ShoppingCart shoppingCart);

    List<ShoppingCart> searchAll();

    List<ShoppingCart> matching(Criteria criteria);
    
    Optional<ShoppingCart> search(ShoppingCartId id);
    
    
}
