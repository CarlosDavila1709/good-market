package store.market.administration.shopping_cart_item.application.search_by_session_product;

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
public final class CartItemBySessionProductSearcher {
	
	private final ItemCartRepository repository;
	
	public CartItemBySessionProductSearcher(ItemCartRepository repository) {
		
		this.repository = repository;
		
	}
	
	public CartItemsResponse search(String sessionId,String productId) {
		Filter filterSession = Filter.create("sessionId", "=", sessionId);
		Filter filterProduct = Filter.create("productId", "=", productId);
		List<Filter> filtersList = new ArrayList<Filter>();
		filtersList.add(filterSession);
		filtersList.add(filterProduct);
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
