package store.market.administration.order_status.domain;

import store.market.shared.domain.DomainError;

public final class OrderStatusNotExist extends DomainError{

    public OrderStatusNotExist(String id) {
        super("status_not_exist", String.format("The status order <%s> doesn't exist", id));
    }
}
