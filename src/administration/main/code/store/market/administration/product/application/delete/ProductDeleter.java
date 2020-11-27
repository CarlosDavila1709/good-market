package store.market.administration.product.application.delete;

import store.market.administration.product.domain.Product;
import store.market.administration.product.domain.ProductId;
import store.market.administration.product.domain.ProductNotExist;
import store.market.administration.product.domain.ProductRepository;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.event.EventBus;

@Service
public final class ProductDeleter {

	private final ProductRepository repository;
    private final EventBus         eventBus;
    
	public ProductDeleter(ProductRepository repository,EventBus         eventBus) {
		 this.repository = repository;
		 this.eventBus   = eventBus;
	}
	public void delete (ProductId id) {
		Product product = repository.search(id).orElseThrow(()->new ProductNotExist(id));
		product.prepareElimination();
		repository.delete(product);
		eventBus.publish(product.pullDomainEvents());
	}
}
