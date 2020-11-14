package store.market.administration.customer.application.search_by_phone;


import java.util.Optional;

import store.market.administration.customer.application.CustomerResponse;
import store.market.administration.customer.domain.Customer;
import store.market.administration.customer.domain.CustomerPhone;
import store.market.administration.customer.domain.CustomerRepository;

import store.market.shared.domain.Service;

@Service
public final class CustomerByPhoneSearch {

	private final CustomerRepository repository;
	
	public CustomerByPhoneSearch(CustomerRepository repository) {
		
		this.repository = repository;
		
	}
	
	public CustomerResponse search(String phone) {
		
		Optional<Customer> response = repository.searchByPhone( new CustomerPhone(phone));
		
		if( !response.isPresent() ) {
			return null;
		}
		return CustomerResponse.fromAggregate(response.get());
	}
}
