package store.market.administration.shopping_cart_item.application.remove;

import store.market.administration.shopping_cart_item.domain.CartItem;
import store.market.administration.shopping_cart_item.domain.CartItemId;
import store.market.administration.shopping_cart_item.domain.CartItemNotExist;
import store.market.administration.shopping_cart_item.domain.ItemCartRepository;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.event.EventBus;

@Service
public final class ItemRemoveter {

	private ItemCartRepository repository;
    private final EventBus         eventBus;
	
	public ItemRemoveter(ItemCartRepository repository,EventBus         eventBus) {
		
		this.repository = repository;
		this.eventBus   = eventBus;
	}
	
	public void remover(CartItemId id) {
		
		CartItem cartItem = repository.search(id).orElseThrow(() -> new CartItemNotExist(id));
		cartItem.prepareElimination();
		repository.delete(cartItem);
		eventBus.publish(cartItem.pullDomainEvents());
	}
}
