package store.market.administration.shopping_cart_item.application.search_by_criteria;

import store.market.administration.shopping_cart_item.application.CartItemResponse;
import store.market.administration.shopping_cart_item.application.CartItemsResponse;
import store.market.administration.shopping_cart_item.domain.ItemCartRepository;
import store.market.shared.domain.Service;
import store.market.shared.domain.criteria.Criteria;
import store.market.shared.domain.criteria.Filters;
import store.market.shared.domain.criteria.Order;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class CartItemsByCriteriaSearcher {
	   
	private final ItemCartRepository repository;

    public CartItemsByCriteriaSearcher(ItemCartRepository repository) {
        this.repository = repository;
    }

    public CartItemsResponse search(
        Filters filters,
        Order order,
        Optional<Integer> limit,
        Optional<Integer> offset
    ) {
        Criteria criteria = new Criteria(filters, order, limit, offset);

        return new CartItemsResponse(
            repository.matching(criteria)
                      .stream()
                      .map(CartItemResponse::fromAggregate)
                      .collect(Collectors.toList())
        );
    }
}
