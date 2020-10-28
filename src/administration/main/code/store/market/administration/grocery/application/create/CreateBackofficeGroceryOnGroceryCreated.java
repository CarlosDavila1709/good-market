package store.market.administration.grocery.application.create;

import org.springframework.context.event.EventListener;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.event.DomainEventSubscriber;
import store.market.shared.domain.grocery.GroceryCreatedDomainEvent;

@Service
@DomainEventSubscriber({GroceryCreatedDomainEvent.class})
public class CreateBackofficeGroceryOnGroceryCreated {

    private final BackofficeGroceryCreator creator;
    
    public CreateBackofficeGroceryOnGroceryCreated(BackofficeGroceryCreator creator) {
        this.creator = creator;
    }
    
    @EventListener
    public void on(GroceryCreatedDomainEvent event) {
        creator.create(event.aggregateId(), event.nameCommercial(), event.address(),event.active());
    }
}
