package store.market.administration.shopping_cart.application.remove_product_to_cart;

import store.market.administration.product.application.ProductResponse;
import store.market.administration.product.application.find.FindProductQuery;
import store.market.administration.product_catalog.domain.ProductCatalogId;
import store.market.administration.shopping_cart.domain.SessionNotExistNotInitialized;
import store.market.administration.shopping_cart.domain.ShoppingCart;
import store.market.administration.shopping_cart.domain.ShoppingCartRepository;
import store.market.administration.shopping_cart.domain.ShoppingCartSessionId;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.event.EventBus;
import store.market.shared.domain.bus.query.QueryBus;

@Service
public final class RemoveProductShoppingCart {

	private ShoppingCartRepository repository;
	private final QueryBus queryBus;
    private final EventBus         eventBus;
    
	public RemoveProductShoppingCart(ShoppingCartRepository repository,QueryBus queryBus, EventBus eventBus) {
		
		this.repository = repository;
		this.queryBus = queryBus;
		this.eventBus = eventBus;
	}
	
	public void remove(ShoppingCartSessionId sessionId,ProductCatalogId productId) {
		
		ShoppingCart cart = repository.searchSession(sessionId).orElseThrow(()->{ throw new SessionNotExistNotInitialized();});
		ProductResponse product = queryBus.ask(new FindProductQuery(productId.value()));
		
		cart.subtractAmount(product.price(),productId);
		cart.removeProduct(productId);

		repository.save(cart);
		eventBus.publish(cart.pullDomainEvents());
	}
}
