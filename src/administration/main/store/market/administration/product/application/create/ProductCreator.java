package store.market.administration.product.application.create;

import store.market.administration.product.domain.Product;
import store.market.administration.product.domain.ProductCategorieId;
import store.market.administration.product.domain.ProductId;
import store.market.administration.product.domain.ProductName;
import store.market.administration.product.domain.ProductPrice;
import store.market.administration.product.domain.ProductRepository;
import store.market.administration.product.domain.ProductUnitMeasureId;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.event.EventBus;

@Service
public final class ProductCreator {

    private final ProductRepository repository;
    private final EventBus         eventBus;

    public ProductCreator(ProductRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus   = eventBus;
    }

    public void create(ProductId id, ProductCategorieId categorieId, ProductUnitMeasureId unitMeasureId, ProductName name, ProductPrice price) {
        Product product = Product.create(id, categorieId, unitMeasureId, name, price);

        repository.save(product);
        eventBus.publish(product.pullDomainEvents());
    }
}
