package store.market.administration.order.application.search_by_criteria;

import java.util.Optional;
import java.util.stream.Collectors;

import store.market.administration.order.application.OrderResponse;
import store.market.administration.order.application.OrdersResponse;
import store.market.administration.order.domain.OrderRepository;
import store.market.shared.domain.Service;
import store.market.shared.domain.criteria.Criteria;
import store.market.shared.domain.criteria.Filters;
import store.market.shared.domain.criteria.Order;

@Service
public final class OrdersByCriteriaSearcher {

    private final OrderRepository repository;

    public OrdersByCriteriaSearcher(OrderRepository repository) {
        this.repository = repository;
    }

    public OrdersResponse search(
        Filters filters,
        Order order,
        Optional<Integer> limit,
        Optional<Integer> offset
    ) {
        Criteria criteria = new Criteria(filters, order, limit, offset);

        return new OrdersResponse(
            repository.matching(criteria)
                      .stream()
                      .map(OrderResponse::fromAggregate)
                      .collect(Collectors.toList())
        );
    }
}
