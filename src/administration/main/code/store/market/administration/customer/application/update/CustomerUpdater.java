package store.market.administration.customer.application.update;

import store.market.administration.customer.domain.Customer;
import store.market.administration.customer.domain.CustomerAddress;
import store.market.administration.customer.domain.CustomerFirstName;
import store.market.administration.customer.domain.CustomerId;
import store.market.administration.customer.domain.CustomerLastName;
import store.market.administration.customer.domain.CustomerMiddleName;
import store.market.administration.customer.domain.CustomerNotExist;
import store.market.administration.customer.domain.CustomerPhone;
import store.market.administration.customer.domain.CustomerRepository;
import store.market.shared.domain.Service;

@Service
public final class CustomerUpdater  {

    private final CustomerRepository repository;
	
    public CustomerUpdater(CustomerRepository repository) {
    
    	this.repository = repository;

    }
    
    public void update(CustomerId id,CustomerPhone customerPhone,CustomerFirstName customerFirstName, CustomerLastName customerLastName,CustomerMiddleName customerMiddleName, CustomerAddress customerAddress) {
    	
    	Customer cust = repository.search(id).orElseThrow(() -> { throw new CustomerNotExist(id); });

    	cust.updateAddress(customerAddress);
    	cust.updateFirstName(customerFirstName);
    	cust.updateLastName(customerLastName);
    	cust.updateMiddleName(customerMiddleName);
    	cust.updatePhone(customerPhone);
    	
    	repository.save(cust);
    }
}
