package store.market.administration.grocery.domain;

import store.market.shared.domain.DomainError;

public final class BackofficeGroceryNotExist extends DomainError{

    public BackofficeGroceryNotExist(BackofficeGroceryId id) {
        super("backoffice_grocery_not_exist", String.format("The course <%s> doesn't exist", id.value()));
    }
}
