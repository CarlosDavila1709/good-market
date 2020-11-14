package store.market.administration.shopping_cart.application.search_by_session_active;

import java.util.Optional;

import store.market.administration.shopping_cart.application.ShoppingCartResponse;
import store.market.administration.shopping_cart.domain.CartStatusType;
import store.market.administration.shopping_cart.domain.ShoppingCart;
import store.market.administration.shopping_cart.domain.ShoppingCartRepository;
import store.market.administration.shopping_cart.domain.ShoppingCartSessionId;
import store.market.shared.domain.Service;


@Service
public final class ShoppingCartBySessionSearcher {

	private final ShoppingCartRepository repository;
	
	public ShoppingCartBySessionSearcher(ShoppingCartRepository repository) {
		
		this.repository = repository;
		
	}
	
	public  ShoppingCartResponse search(String sessionId) {
		
		Optional<ShoppingCart> response = repository.searchSession( new ShoppingCartSessionId(sessionId));
		
		if( !response.isPresent() ) {
			return null;
		}
		if(CartStatusType.INDICTED.codigo().equals(response.get().status().value())) {
			return null;
		}
		return ShoppingCartResponse.fromAggregate(response.get());
	}
}
