package store.market.administration.order_item.application.find;

import store.market.administration.order_item.application.OrderItemResponse;
import store.market.administration.order_item.domain.ItemId;
import store.market.administration.order_item.domain.ItemNotExist;
import store.market.administration.order_item.domain.ItemRepository;
import store.market.shared.domain.Service;

@Service
public final class OrderItemFinder {

	private final ItemRepository repository;
	
	public OrderItemFinder(ItemRepository repository) {
		
		this.repository = repository;
	}
	
	public OrderItemResponse find(ItemId id) throws ItemNotExist{
        return repository.search(id)
                .map(OrderItemResponse::fromAggregate)
                .orElseThrow(() -> new ItemNotExist(id));
	}
	
}
