package store.market.administration.product.application.update_price;

import store.market.administration.product.domain.Product;
import store.market.administration.product.domain.ProductId;
import store.market.administration.product.domain.ProductNotExist;
import store.market.administration.product.domain.ProductPrice;
import store.market.administration.product.domain.ProductRepository;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.event.EventBus;

@Service
public final class ProductPriceUpdater {

	private ProductRepository repository;
	private final EventBus         eventBus;
	
	public ProductPriceUpdater(ProductRepository repository,EventBus eventBus) {
		this.repository = repository;
		this.eventBus = eventBus;
	}
	public void update(ProductId id, ProductPrice newPrice) {
		
		Product product = repository.search(id).orElseThrow(()->  new ProductNotExist(id));
		
		product.updatePrice(newPrice);
		
		repository.save(product);
		
		eventBus.publish(product.pullDomainEvents());
	}
}
