package store.market.backoffice.grocery.application.search_by_criteria;

import store.market.backoffice.grocery.application.GroceryResponse;
import store.market.backoffice.grocery.application.GrocerysResponse;
import store.market.backoffice.grocery.domain.GroceryRepository;
import store.market.shared.domain.Service;
import store.market.shared.domain.criteria.Criteria;
import store.market.shared.domain.criteria.Filters;
import store.market.shared.domain.criteria.Order;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class GrocerysByCriteriaSearcher {

    private final GroceryRepository repository;
    
    public GrocerysByCriteriaSearcher(GroceryRepository repository) {
    	this.repository = repository;
    }
    
    public GrocerysResponse search(
            Filters filters,
            Order order,
            Optional<Integer> limit,
            Optional<Integer> offset
    		) {
    
        Criteria criteria = new Criteria(filters, order, limit, offset);
        
        return new GrocerysResponse(
        		repository.matching(criteria)
        			.stream()
        			.map(GroceryResponse::fromAggregate)
        			.collect(Collectors.toList()));
    }
}
