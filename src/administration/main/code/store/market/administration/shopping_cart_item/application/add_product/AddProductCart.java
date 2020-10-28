package store.market.administration.shopping_cart_item.application.add_product;

import store.market.administration.shopping_cart_item.domain.CartItemRepository;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.event.EventBus;


public final class AddProductCart {

    private final CartItemRepository repository;
    private final EventBus         eventBus;
    
    public AddProductCart(CartItemRepository repository, EventBus  eventBus) {
    	
    	this.repository = repository;
    	this.eventBus = eventBus;
    }
    
    public void add() {
    	
    }
}
