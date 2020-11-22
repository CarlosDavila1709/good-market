package store.market.administration.product_catalog.application.update_price;

import org.springframework.context.event.EventListener;

import store.market.administration.product_catalog.domain.ProductCatalogId;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.event.DomainEventSubscriber;
import store.market.shared.domain.product.ProductUpdatedDomainEvent;

@Service
@DomainEventSubscriber({ProductUpdatedDomainEvent.class})
public final class UpdateProductsPriceOnProductAggregate {

	private ProductCatalogPriceUpdater updater;
    
	public UpdateProductsPriceOnProductAggregate(ProductCatalogPriceUpdater updater) {
		
		this.updater = updater;
	}
	
	@EventListener
    public void on(ProductUpdatedDomainEvent event) {
		ProductCatalogId productId = new ProductCatalogId(event.aggregateId());
        updater.update(productId, event.price());
    }
}
