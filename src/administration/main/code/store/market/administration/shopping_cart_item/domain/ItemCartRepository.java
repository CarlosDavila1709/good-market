package store.market.administration.shopping_cart_item.domain;

import java.util.List;
import java.util.Optional;

import store.market.shared.domain.criteria.Criteria;

public interface ItemCartRepository {

    void save(CartItem cartItem);

    List<CartItem> matching(Criteria criteria);

	Optional<CartItem> search(CartItemId cartItemId);
	
	List<CartItem> searchAll(String shoppingId) ;
	
}
