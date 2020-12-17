package store.market.administration.order_item.domain;

import store.market.shared.domain.DomainError;

public final class ItemNotExist extends DomainError{

	public ItemNotExist(ItemId id) {
		 
		super("item_not_exist", String.format("The item <%s> doesn't exist", id.value()));
	}
	
}
