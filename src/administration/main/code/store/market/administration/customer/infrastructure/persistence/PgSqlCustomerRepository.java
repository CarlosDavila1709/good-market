package store.market.administration.customer.infrastructure.persistence;

import store.market.administration.customer.domain.Customer;
import store.market.administration.customer.domain.CustomerId;
import store.market.administration.customer.domain.CustomerRepository;
import store.market.shared.domain.Service;
import store.market.shared.domain.criteria.Criteria;
import store.market.shared.infrastructure.hibernate.HibernateRepository;

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
}
