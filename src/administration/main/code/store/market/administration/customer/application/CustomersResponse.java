package store.market.administration.customer.application;

import java.util.List;

import store.market.shared.domain.bus.query.Response;

public final class CustomersResponse implements Response {

    private final List<CustomerResponse> customers;

    public CustomersResponse(List<CustomerResponse> customers) {
        this.customers = customers;
    }

    public List<CustomerResponse> customers() {
        return customers;
    }
    
}
