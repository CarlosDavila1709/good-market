package store.market.administration.customer.domain;

import store.market.shared.domain.DomainError;

public final class CustomerNotExist  extends DomainError {

    public CustomerNotExist(CustomerId id) {
        super("customer_not_exist", String.format("The customer <%s> doesn't exist", id.value()));
    }
}
