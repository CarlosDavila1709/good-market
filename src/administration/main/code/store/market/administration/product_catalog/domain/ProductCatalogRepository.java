package store.market.administration.product_catalog.domain;

import java.util.List;
import java.util.Optional;

import store.market.shared.domain.criteria.Criteria;

public interface ProductCatalogRepository {

    void save(ProductCatalog productCatalog);

    List<ProductCatalog> searchAll();

    List<ProductCatalog> matching(Criteria criteria);
    
    Optional<ProductCatalog> search(ProductCatalogId id);
    
    void delete(ProductCatalog product);
}
