package store.market.administration.shopping_cart_item.application.remove;

import store.market.administration.shopping_cart_item.domain.CartItem;
import store.market.administration.shopping_cart_item.domain.CartItemId;
import store.market.administration.shopping_cart_item.domain.CartItemNotExist;
import store.market.administration.shopping_cart_item.domain.ItemCartRepository;
import store.market.shared.domain.Service;

@Service
public final class ItemRemoveter {

	private ItemCartRepository repository;
	
	public ItemRemoveter(ItemCartRepository repository) {
		
		this.repository = repository;
	}
	
	public void remover(CartItemId id) {
		
		CartItem cartItem = repository.search(id).orElseThrow(() -> { throw new CartItemNotExist(id); });
		
		repository.delete(cartItem);
	}
}
