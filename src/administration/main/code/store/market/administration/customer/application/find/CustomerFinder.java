package store.market.administration.customer.application.find;

import store.market.administration.customer.application.CustomerResponse;
import store.market.administration.customer.domain.CustomerId;
import store.market.administration.customer.domain.CustomerNotExist;
import store.market.administration.customer.domain.CustomerRepository;


public class CustomerFinder {

    private final CustomerRepository repository;

    public CustomerFinder(CustomerRepository repository) {
        this.repository = repository;
    }

    public CustomerResponse find(CustomerId id) throws CustomerNotExist {
        return repository.search(id)
                         .map(CustomerResponse::fromAggregate)
                         .orElseThrow(() -> new CustomerNotExist(id));
    }
}
