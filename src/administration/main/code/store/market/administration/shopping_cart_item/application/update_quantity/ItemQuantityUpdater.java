package store.market.administration.shopping_cart_item.application.update_quantity;

import store.market.administration.shopping_cart_item.domain.CartItem;
import store.market.administration.shopping_cart_item.domain.CartItemId;
import store.market.administration.shopping_cart_item.domain.CartItemNotExist;
import store.market.administration.shopping_cart_item.domain.CartItemQuantity;
import store.market.administration.shopping_cart_item.domain.ItemCartRepository;
import store.market.shared.domain.Service;

@Service
public final class ItemQuantityUpdater {

	private ItemCartRepository repository;
	
	public ItemQuantityUpdater(ItemCartRepository repository) {
		this.repository = repository;
	}
	
	public void update(CartItemId id, CartItemQuantity quantity) {
		
		CartItem cartItem = repository.search(id).orElseThrow(() -> { throw new CartItemNotExist(id); });
		
		cartItem.updateQuantity(quantity);
		
		repository.save(cartItem);
	}
}
