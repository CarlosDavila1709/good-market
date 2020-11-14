package store.market.administration.customer.infrastructure.persistence;

import store.market.administration.customer.domain.Customer;
import store.market.administration.customer.domain.CustomerId;
import store.market.administration.customer.domain.CustomerPhone;
import store.market.administration.customer.domain.CustomerRepository;

import store.market.shared.domain.Service;
import store.market.shared.domain.criteria.Criteria;
import store.market.shared.domain.criteria.Filter;
import store.market.shared.domain.criteria.Filters;
import store.market.shared.domain.criteria.Order;
import store.market.shared.infrastructure.hibernate.HibernateRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional("administration-transaction_manager")
public class PgSqlCustomerRepository extends HibernateRepository<Customer> implements CustomerRepository {

    public PgSqlCustomerRepository(@Qualifier("administration-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Customer.class);
    }

    @Override
    public void save(Customer course) {
        persist(course);
    }

    @Override
    public Optional<Customer> search(CustomerId id) {
        return byId(id);
    }

    @Override
    public List<Customer> matching(Criteria criteria) {
        return byCriteria(criteria);
    }

	@Override
	public Optional<Customer> searchByPhone(CustomerPhone phone) {
		Filters filters = filtersPhoneCustomer(phone);
        Criteria criteria = new Criteria(
        		filters,
                Order.none(),
                Optional.empty(),
                Optional.empty()
            );
		
        List<Customer> customers = byCriteria(criteria);
        return 0 ==  customers.size() ? Optional.empty() : Optional.ofNullable(customers.get(0));
	}

    private Filters filtersPhoneCustomer(CustomerPhone phone) {
		
    	Filter filterSession = Filter.create("customerPhone", "=", phone.value());
		
		List<Filter> filtersList = new ArrayList<Filter>();
		filtersList.add(filterSession);
		
		return new Filters(filtersList);
    }
}
