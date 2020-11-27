package store.market.administration.product.domain;

import java.util.List;
import java.util.Optional;

import store.market.shared.domain.criteria.Criteria;

public interface ProductRepository {

    void save(Product product);

    List<Product> searchAll();

    List<Product> matching(Criteria criteria);
    
    Optional<Product> search(ProductId id);
    
    void delete(Product product);
}
