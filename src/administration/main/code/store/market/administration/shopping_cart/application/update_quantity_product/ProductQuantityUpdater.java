package store.market.administration.shopping_cart.application.update_quantity_product;

import store.market.administration.product.application.ProductResponse;
import store.market.administration.product.application.find.FindProductQuery;
import store.market.administration.product_catalog.domain.ProductCatalogId;
import store.market.administration.shopping_cart.domain.SessionNotExistNotInitialized;
import store.market.administration.shopping_cart.domain.ShoppingCart;
import store.market.administration.shopping_cart.domain.ShoppingCartAmountTotal;
import store.market.administration.shopping_cart.domain.ShoppingCartQuantity;
import store.market.administration.shopping_cart.domain.ShoppingCartRepository;
import store.market.administration.shopping_cart.domain.ShoppingCartSessionId;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.event.EventBus;
import store.market.shared.domain.bus.query.QueryBus;

@Service
public final class ProductQuantityUpdater {

	private final QueryBus 		   queryBus;
	private final EventBus         eventBus;
	private ShoppingCartRepository repository;
	
	public ProductQuantityUpdater(ShoppingCartRepository repository,QueryBus queryBus,EventBus eventBus) {
		
		this.repository = repository;
		this.queryBus = queryBus;
		this.eventBus = eventBus;
	}
	
	public void update(ShoppingCartSessionId sessionId,ProductCatalogId productId, ShoppingCartQuantity quantity) {
		
		ShoppingCart cart = repository.searchSession(sessionId).orElseThrow(()->{ throw new SessionNotExistNotInitialized();});
		ProductResponse product = queryBus.ask(new FindProductQuery(productId.value()));
		
		cart.addProduct(productId,quantity);
		cart.addAmount(new ShoppingCartAmountTotal(product.price()),quantity);
		
		repository.save(cart);
		
		eventBus.publish(cart.pullDomainEvents());
	}
}
