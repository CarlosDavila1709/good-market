package store.market.administration.grocery.domain;

import java.util.List;
import java.util.Optional;

import store.market.shared.domain.criteria.Criteria;

public interface BackofficeGroceryRepository {

    void save(BackofficeGrocery course);

    List<BackofficeGrocery> searchAll();

    List<BackofficeGrocery> matching(Criteria criteria);
    
    Optional<BackofficeGrocery> search(BackofficeGroceryId id);
}
