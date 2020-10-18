package store.market.backoffice.grocery.application.create;

import store.market.backoffice.grocery.domain.Grocery;
import store.market.backoffice.grocery.domain.GroceryActive;
import store.market.backoffice.grocery.domain.GroceryAddress;
import store.market.backoffice.grocery.domain.GroceryId;
import store.market.backoffice.grocery.domain.GroceryNameCommercial;
import store.market.backoffice.grocery.domain.GroceryRepository;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.event.EventBus;

@Service
public final class GroceryCreator {

	private final GroceryRepository repository;
	
	private final EventBus eventBus;
	
	public GroceryCreator(GroceryRepository repository,EventBus eventBus) {
		
		this.repository = repository;
		this.eventBus = eventBus;
	}
	
	public void create(GroceryId id, GroceryNameCommercial nameCommercial, GroceryAddress address, GroceryActive active) {
		
		
		Grocery grocery = Grocery.create(id, nameCommercial, address, active);
		
		repository.save(grocery);
		
		eventBus.publish(grocery.pullDomainEvents());
		
	}
	
}
