package store.market.administration.order.domain;

import store.market.shared.domain.DomainError;

public final class OrderNotExist extends DomainError {

    public OrderNotExist(OrderId id) {
        super("order_not_exist", String.format("The order <%s> doesn't exist", id.value()));
    }
}
