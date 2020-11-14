package store.market.administration.customer.application.create;

import store.market.administration.customer.domain.CustomerAddress;
import store.market.administration.customer.domain.CustomerFirstName;
import store.market.administration.customer.domain.CustomerId;
import store.market.administration.customer.domain.CustomerLastName;
import store.market.administration.customer.domain.CustomerMiddleName;
import store.market.administration.customer.domain.CustomerPhone;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateCustomerCommandHandler implements CommandHandler<CreateCustomerCommand> {

    private final CustomerCreator creator;

    public CreateCustomerCommandHandler(CustomerCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateCustomerCommand command) {

        CustomerId id = new CustomerId(command.id());
		CustomerPhone  customerPhone = new CustomerPhone(command.customerPhone());
		CustomerFirstName customerFirstName = new CustomerFirstName(command.customerFirstName());
		CustomerLastName customerLastName = new CustomerLastName(command.customerLastName());
		CustomerMiddleName customerMiddleName = new CustomerMiddleName(command.customerMiddleName());
		CustomerAddress customerAddress = new CustomerAddress(command.customerAddress());

        creator.create(id, customerPhone, customerFirstName,  customerLastName, customerMiddleName,  customerAddress);
    }
}
