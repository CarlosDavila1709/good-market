package store.market.administration.product_catalog.application.create;

import org.springframework.context.event.EventListener;

import store.market.shared.domain.Service;
import store.market.shared.domain.bus.event.DomainEventSubscriber;
import store.market.shared.domain.product.ProductCreatedDomainEvent;

@Service
@DomainEventSubscriber({ProductCreatedDomainEvent.class})
public final class CreateProductCatalogOnProductCreated {

	private final ProductCatalogCreator creator;
	
	public CreateProductCatalogOnProductCreated(ProductCatalogCreator creator) {
		
		this.creator = creator;
	}
	
    @EventListener
    public void on(ProductCreatedDomainEvent event) {
        
    	creator.create(event.aggregateId());
    	
    }
}
