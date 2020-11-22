package store.market.administration.order_status.application.find;

import store.market.administration.order_status.application.StatusOrderResponse;
import store.market.administration.order_status.domain.OrderStatusNotExist;
import store.market.administration.order_status.domain.StatusOrderRepository;
import store.market.shared.domain.Service;

@Service
public final class OrderStatusFinder {

    private final StatusOrderRepository repository;

    public OrderStatusFinder(StatusOrderRepository repository) {
        this.repository = repository;
    }

    public StatusOrderResponse find(String codigo) throws OrderStatusNotExist {
        return repository.search(codigo)
                         .map(StatusOrderResponse::fromAggregate)
                         .orElseThrow(() -> new OrderStatusNotExist(codigo));
    }
}
