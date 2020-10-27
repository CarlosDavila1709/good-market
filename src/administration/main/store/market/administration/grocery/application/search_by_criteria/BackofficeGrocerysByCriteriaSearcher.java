package store.market.administration.grocery.application.search_by_criteria;

import store.market.administration.grocery.application.BackofficeGroceryResponse;
import store.market.administration.grocery.application.BackofficeGrocerysResponse;
import store.market.administration.grocery.domain.BackofficeGroceryRepository;
import store.market.shared.domain.Service;
import store.market.shared.domain.criteria.Criteria;
import store.market.shared.domain.criteria.Filters;
import store.market.shared.domain.criteria.Order;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BackofficeGrocerysByCriteriaSearcher {

    private final BackofficeGroceryRepository repository;
    
    public BackofficeGrocerysByCriteriaSearcher(BackofficeGroceryRepository repository) {
        this.repository = repository;
    }

    public BackofficeGrocerysResponse search(
        Filters filters,
        Order order,
        Optional<Integer> limit,
        Optional<Integer> offset
    ) {
        Criteria criteria = new Criteria(filters, order, limit, offset);

        return new BackofficeGrocerysResponse(
            repository.matching(criteria)
                      .stream()
                      .map(BackofficeGroceryResponse::fromAggregate)
                      .collect(Collectors.toList())
        );
    }
}
