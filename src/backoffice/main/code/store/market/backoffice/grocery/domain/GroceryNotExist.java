package store.market.backoffice.grocery.domain;

import store.market.shared.domain.DomainError;

public final class GroceryNotExist extends DomainError{

	  public GroceryNotExist(GroceryId id) {
	        super("grocery_not_exist", String.format("The grocery <%s> doesn't exist", id.value()));
	  }
}
