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

        CustomerId id = new CustomerId();
		CustomerPhone  customerPhone = new CustomerPhone();
		CustomerFirstName customerFirstName = new CustomerFirstName();
		CustomerLastName customerLastName = new CustomerLastName();
		CustomerMiddleName customerMiddleName = new CustomerMiddleName();
		CustomerAddress customerAddress = new CustomerAddress();

        creator.create(id, customerPhone, customerFirstName,  customerLastName, customerMiddleName,  customerAddress);
    }
}
