package store.market.administration.customer.application.create;

import store.market.administration.customer.domain.Customer;
import store.market.administration.customer.domain.CustomerAddress;
import store.market.administration.customer.domain.CustomerFirstName;
import store.market.administration.customer.domain.CustomerId;
import store.market.administration.customer.domain.CustomerLastName;
import store.market.administration.customer.domain.CustomerMiddleName;
import store.market.administration.customer.domain.CustomerPhone;
import store.market.administration.customer.domain.CustomerRepository;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.event.EventBus;

@Service
public final class CustomerCreator {

    private final CustomerRepository repository;
    private final EventBus         eventBus;

    public CustomerCreator(CustomerRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus   = eventBus;
    }

    public void create(CustomerId id,CustomerPhone customerPhone,CustomerFirstName customerFirstName, CustomerLastName customerLastName,CustomerMiddleName customerMiddleName, CustomerAddress customerAddress) {
        Customer customer = Customer.create( id, customerPhone, customerFirstName,  customerLastName, customerMiddleName,  customerAddress);

        repository.save(customer);
        //eventBus.publish(customer.pullDomainEvents());
    }
}
