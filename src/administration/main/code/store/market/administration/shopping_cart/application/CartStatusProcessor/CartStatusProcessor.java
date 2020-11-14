package store.market.administration.shopping_cart.application.CartStatusProcessor;

import store.market.administration.shopping_cart.domain.CartStatusType;
import store.market.administration.shopping_cart.domain.ShoppingCart;
import store.market.administration.shopping_cart.domain.ShoppingCartId;
import store.market.administration.shopping_cart.domain.ShoppingCartNotExist;
import store.market.administration.shopping_cart.domain.ShoppingCartRepository;
import store.market.administration.shopping_cart.domain.ShoppingCartStatus;
import store.market.shared.domain.Service;

@Service
public final class CartStatusProcessor {

	private final ShoppingCartRepository repository;
	
	public CartStatusProcessor(ShoppingCartRepository repository) {
		this.repository = repository;
	}
	public void process(ShoppingCartId id) {
		
		ShoppingCart shoppingCart = repository.search(id).orElseThrow(
				()->new ShoppingCartNotExist(id)
				);

		ShoppingCartStatus statusIndicted = new ShoppingCartStatus(CartStatusType.INDICTED.codigo());
		shoppingCart.updateStatus(statusIndicted);
		repository.save(shoppingCart);
	}
	
}
