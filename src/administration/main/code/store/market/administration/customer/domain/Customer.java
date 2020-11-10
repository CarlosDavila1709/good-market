package store.market.administration.customer.domain;

import java.util.Objects;

import store.market.shared.domain.AggregateRoot;

public final class Customer extends AggregateRoot{

	private final CustomerId id;
	private final CustomerPhone customerPhone;
	private final CustomerFirstName customerFirstName;
	private final CustomerLastName customerLastName;
	private final CustomerMiddleName customerMiddleName;
	private final CustomerAddress customerAddress;
	
	public Customer(CustomerId id,CustomerPhone customerPhone,CustomerFirstName customerFirstName, CustomerLastName customerLastName,CustomerMiddleName customerMiddleName, CustomerAddress customerAddress) {
		this.id = id;
		this.customerPhone = customerPhone;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerMiddleName = customerMiddleName;
		this.customerAddress= customerAddress;
	}
	public Customer() {
		
		this.id = null;
		this.customerPhone = null;
		this.customerFirstName = null;
		this.customerLastName = null;
		this.customerMiddleName = null;
		this.customerAddress= null;
	}
	
	public static Customer create(CustomerId id,CustomerPhone customerPhone,CustomerFirstName customerFirstName, CustomerLastName customerLastName,CustomerMiddleName customerMiddleName, CustomerAddress customerAddress) {
		
		Customer customer = new Customer( id, customerPhone, customerFirstName,  customerLastName, customerMiddleName,  customerAddress);
		
		//customer.record(new CustomerCreatedDomainEvent(id.value(), categorieId.value(), unitMeasureId.value(), name.value(), price.value()));
		
		return customer;
	}
	
	
    public CustomerId id() {
        return id;
    }
    public CustomerPhone customerPhone() {
        return customerPhone;
    }
    public CustomerFirstName customerFirstName() {
        return customerFirstName;
    }
    public CustomerLastName customerLastName() {
        return customerLastName;
    }   
    public CustomerMiddleName customerMiddleName() {
        return customerMiddleName;
    }
    public CustomerAddress customerAddress() {
        return customerAddress;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Customer customer = (Customer) o;
        return id.equals(customer.id) &&
        		customerPhone.equals(customer.customerPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash( id, customerPhone, customerFirstName,  customerLastName, customerMiddleName,  customerAddress);
    }
}
