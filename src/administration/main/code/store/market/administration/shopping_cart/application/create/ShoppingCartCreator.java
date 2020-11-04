package store.market.administration.shopping_cart.application.create;

import store.market.administration.shopping_cart.domain.ShoppingCart;
import store.market.administration.shopping_cart.domain.ShoppingCartAmountTotal;
import store.market.administration.shopping_cart.domain.ShoppingCartId;
import store.market.administration.shopping_cart.domain.ShoppingCartRepository;
import store.market.administration.shopping_cart.domain.ShoppingCartSessionId;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.event.EventBus;

@Service
public final class ShoppingCartCreator {

    private final ShoppingCartRepository repository;
    private final EventBus         eventBus;

    public ShoppingCartCreator(ShoppingCartRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus   = eventBus;
    }

    public void create(ShoppingCartId id,ShoppingCartSessionId sessionId, ShoppingCartAmountTotal amountTotal) {
        
    	ShoppingCart shoppingCart  = ShoppingCart.create(id, sessionId, amountTotal);

        repository.save(shoppingCart);
       
        eventBus.publish(shoppingCart.pullDomainEvents());
    }
}
