package store.market.administration.shopping_cart_item.application.add_item;

import store.market.administration.product.application.ProductResponse;
import store.market.administration.product.application.find.FindProductQuery;

import store.market.administration.shopping_cart_item.domain.ShoppingCartSessionId;
import store.market.administration.shopping_cart_item.domain.*;

import store.market.shared.domain.Service;
import store.market.shared.domain.UuidGenerator;
import store.market.shared.domain.bus.query.QueryBus;

@Service
public final class AddItemsOnCart {

    private final ItemCartRepository repository;
    private final UuidGenerator uuidGenerator;
	private final QueryBus queryBus;
	
	public AddItemsOnCart(ItemCartRepository repository,UuidGenerator uuidGenerator,QueryBus queryBus) {
		
		this.repository = repository;
    	this.uuidGenerator = uuidGenerator;
    	this.queryBus = queryBus;
	}
	
	public void add(ShoppingCartSessionId sessionId, CartItemProductId productId, CartItemQuantity quantity) {
		
		ProductResponse product = queryBus.ask(new FindProductQuery(productId.value()));
		
		CartItem cartItem = repository.search(sessionId, productId)
				.orElseGet(
						() -> CartItem.initialize(
								new CartItemId(uuidGenerator.generate()),
								new ShoppingCartSessionId(sessionId.value()), 
								new CartItemProductId(productId.value()), 
								new CartItemProductPrice(product.price()), 
								new CartItemProductName(product.name()))
						);
    	
		cartItem.increment(new CartItemQuantity(quantity.value()));
		cartItem.addAmount(new CartItemProductPrice(product.price()), new CartItemQuantity(quantity.value()));
		
		repository.save(cartItem);
		
	}
}
