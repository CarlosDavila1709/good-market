package store.market.administration.customer.application;

import store.market.administration.customer.domain.Customer;
import store.market.shared.domain.bus.query.Response;

public final class CustomerResponse implements Response {

	private final String id;
	private final String customerPhone;
	private final String customerFirstName;
	private final String customerLastName;
	private final String customerMiddleName;
	private final String customerAddress;
	
	public CustomerResponse(String id,String customerPhone,String customerFirstName, String customerLastName,String customerMiddleName, String customerAddress) {
		
		this.id = id;
		this.customerPhone = customerPhone;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerMiddleName = customerMiddleName;
		this.customerAddress= customerAddress;
	}
    public static CustomerResponse fromAggregate(Customer customer) {
        return new CustomerResponse(customer.id().value(), customer.customerPhone().value(), customer.customerFirstName().value(), customer.customerLastName().value(), customer.customerMiddleName().value(), customer.customerAddress().value());
    }

    public String id() {
        return id;
    }
    public String customerPhone() {
        return customerPhone;
    }
    public String customerFirstName() {
        return customerFirstName;
    }
    public String customerLastName() {
        return customerLastName;
    }   
    public String customerMiddleName() {
        return customerMiddleName;
    }
    public String customerAddress() {
        return customerAddress;
    }
}
