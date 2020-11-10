package store.market.administration.customer.application.find;

import store.market.administration.customer.application.CustomerResponse;
import store.market.administration.customer.domain.CustomerId;
import store.market.administration.customer.domain.CustomerNotExist;
import store.market.shared.domain.bus.query.QueryHandler;

public class FindCustomerQueryHandler  implements QueryHandler<FindCustomerQuery, CustomerResponse> {

    private final CustomerFinder finder;

    public FindCustomerQueryHandler(CustomerFinder finder) {
        this.finder = finder;
    }

    @Override
    public CustomerResponse handle(FindCustomerQuery query) throws CustomerNotExist {
        return finder.find(new CustomerId(query.id()));
    }
}
