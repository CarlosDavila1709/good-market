package store.market.backoffice.grocery.domain;

import java.util.List;
import java.util.Optional;

import store.market.shared.domain.criteria.Criteria;

public interface GroceryRepository {

	void save(Grocery grocery);
	
	Optional<Grocery> search(GroceryId id);
	
	List<Grocery> matching(Criteria criteria);
	
}
