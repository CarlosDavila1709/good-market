package store.market.administration.shopping_cart.application.add_product_to_card;

import store.market.administration.product.application.ProductResponse;
import store.market.administration.product.application.find.FindProductQuery;
import store.market.administration.product.domain.ProductId;
import store.market.administration.shopping_cart.domain.ShoppingCart;
import store.market.administration.shopping_cart.domain.ShoppingCartAmountTotal;
import store.market.administration.shopping_cart.domain.ShoppingCartId;
import store.market.administration.shopping_cart.domain.ShoppingCartQuantity;
import store.market.administration.shopping_cart.domain.ShoppingCartRepository;
import store.market.administration.shopping_cart.domain.ShoppingCartSessionId;

import store.market.shared.domain.Service;
import store.market.shared.domain.UuidGenerator;
import store.market.shared.domain.bus.event.EventBus;
import store.market.shared.domain.bus.query.QueryBus;

@Service
public final class AddProductShoppingCart {

	private ShoppingCartRepository repository;
	private UuidGenerator uuidGenerator;
	private final QueryBus queryBus;
    private final EventBus         eventBus;

	public AddProductShoppingCart(ShoppingCartRepository repository, UuidGenerator uuidGenerator, QueryBus queryBus, EventBus eventBus) {
		this.repository = repository;
		this.uuidGenerator = uuidGenerator;
		this.queryBus = queryBus;
		this.eventBus = eventBus;
	}

	public void add(ShoppingCartSessionId sessionId, ProductId productId, ShoppingCartQuantity quantity) {

		ProductResponse product = queryBus.ask(new FindProductQuery(productId.value()));
		ShoppingCart cart = repository.search(sessionId)
				.orElseGet(
						() -> ShoppingCart.initialize(
						new ShoppingCartId(uuidGenerator.generate()),
						new ShoppingCartSessionId(sessionId.value())
						));
		
		cart.addProduct(productId,quantity);
		cart.addAmount(new ShoppingCartAmountTotal(product.price()),quantity);

		repository.save(cart);
		
		eventBus.publish(cart.pullDomainEvents());
	}
}
