package store.market.administration.customer.domain;

import java.util.List;
import java.util.Optional;

import store.market.shared.domain.criteria.Criteria;

public interface CustomerRepository {
    
	void save(Customer course);

    Optional<Customer> search(CustomerId id);

    List<Customer> matching(Criteria criteria);
}
