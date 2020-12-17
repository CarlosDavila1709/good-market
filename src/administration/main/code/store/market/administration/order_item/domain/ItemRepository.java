package store.market.administration.order_item.domain;

import java.util.List;
import java.util.Optional;

import store.market.shared.domain.criteria.Criteria;

public interface ItemRepository {

	void save(Item item);

    Optional<Item> search(ItemId id);

    List<Item> matching(Criteria criteria);
    
    void delete(Item item);
}
