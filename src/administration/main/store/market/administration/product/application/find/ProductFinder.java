package store.market.administration.product.application.find;

import store.market.administration.product.application.ProductResponse;
import store.market.administration.product.domain.ProductId;
import store.market.administration.product.domain.ProductNotExist;
import store.market.administration.product.domain.ProductRepository;
import store.market.shared.domain.Service;

@Service
public final class ProductFinder {

    private final ProductRepository repository;

    public ProductFinder(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductResponse find(ProductId id) throws ProductNotExist {
        return repository.search(id)
                         .map(ProductResponse::fromAggregate)
                         .orElseThrow(() -> new ProductNotExist(id));
    }
}
