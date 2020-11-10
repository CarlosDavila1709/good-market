package store.market.administration.customer.application.create;

import store.market.shared.domain.bus.command.Command;

public final class CreateCustomerCommand implements Command {

	private final String id;
	private final String customerPhone;
	private final String customerFirstName;
	private final String customerLastName;
	private final String customerMiddleName;
	private final String customerAddress;

    public CreateCustomerCommand(String id,String customerPhone,String customerFirstName, String customerLastName,String customerMiddleName, String customerAddress) {
		
		this.id = id;
		this.customerPhone = customerPhone;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerMiddleName = customerMiddleName;
		this.customerAddress= customerAddress;
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
