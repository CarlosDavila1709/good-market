package store.market.administration.shopping_cart.application.search_by_session;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import store.market.administration.shopping_cart.application.ShoppingCartResponse;
import store.market.administration.shopping_cart.application.ShoppingCartsResponse;
import store.market.administration.shopping_cart.domain.ShoppingCart;
import store.market.administration.shopping_cart.domain.ShoppingCartRepository;
import store.market.administration.shopping_cart.domain.ShoppingCartSessionId;
import store.market.shared.domain.Service;
import store.market.shared.domain.criteria.Criteria;
import store.market.shared.domain.criteria.Filter;
import store.market.shared.domain.criteria.Filters;
import store.market.shared.domain.criteria.Order;

@Service
public final class ShoppingCartBySessionSearcher {

	private final ShoppingCartRepository repository;
	
	public ShoppingCartBySessionSearcher(ShoppingCartRepository repository) {
		
		this.repository = repository;
		
	}
	
	/*
	public ShoppingCartsResponse search(String sessionId) {
		Filter filter = Filter.create("sessionId", "=", sessionId);
		List<Filter> filtersList = new ArrayList<Filter>();
		filtersList.add(filter);
		Filters filters = new Filters(filtersList);
		
		Criteria criteria = new Criteria(
				filters,
	            Order.none(),
	            Optional.empty(),
	            Optional.empty()
	        );
        return new ShoppingCartsResponse(
                repository.matching(criteria).stream().map(ShoppingCartResponse::fromAggregate).collect(Collectors.toList())
            );
      
	}
	*/
	public  ShoppingCartResponse search(String sessionId) {
		
		Optional<ShoppingCart> response = repository.search( new ShoppingCartSessionId(sessionId));
		
		if( !response.isPresent() ) {
			return null;
		}
		return ShoppingCartResponse.fromAggregate(repository.search( new ShoppingCartSessionId(sessionId)).get());
	}
}
