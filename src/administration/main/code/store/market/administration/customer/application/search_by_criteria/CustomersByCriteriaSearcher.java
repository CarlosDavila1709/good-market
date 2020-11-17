package store.market.administration.customer.application.search_by_criteria;

import java.util.Optional;
import java.util.stream.Collectors;

import store.market.administration.customer.application.CustomerResponse;
import store.market.administration.customer.application.CustomersResponse;
import store.market.administration.customer.domain.CustomerRepository;
import store.market.shared.domain.Service;
import store.market.shared.domain.criteria.Criteria;
import store.market.shared.domain.criteria.Filters;
import store.market.shared.domain.criteria.Order;

@Service
public final class CustomersByCriteriaSearcher {

    private final CustomerRepository repository;
    
    public CustomersByCriteriaSearcher(CustomerRepository repository) {
        this.repository = repository;
    }

    public CustomersResponse search(
        Filters filters,
        Order order,
        Optional<Integer> limit,
        Optional<Integer> offset
    ) {
        Criteria criteria = new Criteria(filters, order, limit, offset);

        return new CustomersResponse(
            repository.matching(criteria)
                      .stream()
                      .map(CustomerResponse::fromAggregate)
                      .collect(Collectors.toList())
        );
    }
}
