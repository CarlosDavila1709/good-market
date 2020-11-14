package store.market.administration.shopping_cart_item.application.search_by_cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import store.market.administration.shopping_cart_item.application.CartItemResponse;
import store.market.administration.shopping_cart_item.application.CartItemsResponse;
import store.market.administration.shopping_cart_item.domain.ItemCartRepository;
import store.market.shared.domain.Service;
import store.market.shared.domain.criteria.Criteria;
import store.market.shared.domain.criteria.Filter;
import store.market.shared.domain.criteria.Filters;
import store.market.shared.domain.criteria.Order;

@Service
public final class CartItemByCartSearcher {

	private final ItemCartRepository repository;
	
	public CartItemByCartSearcher(ItemCartRepository repository) {
		
		this.repository = repository;
	}
	
	public CartItemsResponse search(String shoppingCartId) {
		Filter filterSession = Filter.create("shoppingCartId", "=", shoppingCartId);
		List<Filter> filtersList = new ArrayList<Filter>();
		filtersList.add(filterSession);
		Filters filters = new Filters(filtersList);
		
		Criteria criteria = new Criteria(
				filters,
	            Order.none(),
	            Optional.empty(),
	            Optional.empty()
	        );
        return new CartItemsResponse(
                repository.matching(criteria).stream().map(CartItemResponse::fromAggregate).collect(Collectors.toList())
            );
	}
}
