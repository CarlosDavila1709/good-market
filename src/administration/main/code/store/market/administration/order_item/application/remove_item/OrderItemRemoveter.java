package store.market.administration.order_item.application.remove_item;

import store.market.administration.order.domain.OrderId;
import store.market.administration.order_item.domain.Item;
import store.market.administration.order_item.domain.ItemId;
import store.market.administration.order_item.domain.ItemNotExist;
import store.market.administration.order_item.domain.ItemRepository;
import store.market.shared.domain.Service;

@Service
public final class OrderItemRemoveter {

	private final ItemRepository repository;
	
	public OrderItemRemoveter(ItemRepository repository) {
		
		this.repository = repository;
	}
	
	public void remover(OrderId id, ItemId itemId) {
		
		Item item =  repository.search(itemId).orElseThrow(()-> new ItemNotExist(itemId));
		
		if(item.orderId().value().equals(id.value()))
			repository.delete(item);
	}
}
