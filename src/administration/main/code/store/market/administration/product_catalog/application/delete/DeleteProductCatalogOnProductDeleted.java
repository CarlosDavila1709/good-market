package store.market.administration.product_catalog.application.delete;

import org.springframework.context.event.EventListener;

import store.market.administration.product_catalog.domain.ProductCatalogId;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.event.DomainEventSubscriber;
import store.market.shared.domain.product.ProductDeletedAggregateDomainEvent;

@Service
@DomainEventSubscriber({ProductDeletedAggregateDomainEvent.class})
public final class DeleteProductCatalogOnProductDeleted {

	private final ProductCatalogDeleter deleter;
	
	public DeleteProductCatalogOnProductDeleted(ProductCatalogDeleter deleter) {
		this.deleter = deleter;
	}
    @EventListener
    public void on(ProductDeletedAggregateDomainEvent event) {
    	ProductCatalogId id = new ProductCatalogId(event.aggregateId());
    	deleter.delete(id);
    }
}
