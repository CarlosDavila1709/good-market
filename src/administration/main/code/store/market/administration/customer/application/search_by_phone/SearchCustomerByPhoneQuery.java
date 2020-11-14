package store.market.administration.customer.application.search_by_phone;

import java.util.Objects;

import store.market.shared.domain.bus.query.Query;

public final class SearchCustomerByPhoneQuery implements Query {

	private final String phone;
	
	public SearchCustomerByPhoneQuery(String phone) {
		
		this.phone = phone;
	}
	public String phone() {
		return phone;
	}
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SearchCustomerByPhoneQuery that = (SearchCustomerByPhoneQuery) o;
        return phone.equals(that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone);
    }
}
