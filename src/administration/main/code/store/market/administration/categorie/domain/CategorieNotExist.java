package store.market.administration.categorie.domain;

import store.market.shared.domain.DomainError;

public final class CategorieNotExist extends DomainError{

    public CategorieNotExist(CategorieId id) {
        super("categorie_not_exist", String.format("The categorie <%s> doesn't exist", id.value()));
    }
}
