package store.market.administration.order.application.find;

import store.market.administration.order.application.OrderResponse;
import store.market.administration.order.domain.OrderId;
import store.market.administration.order.domain.OrderNotExist;
import store.market.administration.order.domain.OrderRepository;
import store.market.shared.domain.Service;

@Service
public class OrderFinder {

    private final OrderRepository repository;

    public OrderFinder(OrderRepository repository) {
        this.repository = repository;
    }

    public OrderResponse find(OrderId id) throws OrderNotExist {
        return repository.search(id)
                         .map(OrderResponse::fromAggregate)
                         .orElseThrow(() -> new OrderNotExist(id));
    }
}
