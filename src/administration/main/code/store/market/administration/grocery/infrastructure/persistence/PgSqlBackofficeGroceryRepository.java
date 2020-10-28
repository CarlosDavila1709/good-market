package store.market.administration.grocery.infrastructure.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import store.market.administration.grocery.domain.BackofficeGrocery;
import store.market.administration.grocery.domain.BackofficeGroceryId;
import store.market.administration.grocery.domain.BackofficeGroceryRepository;
import store.market.shared.domain.Service;
import store.market.shared.domain.criteria.Criteria;
import store.market.shared.infrastructure.hibernate.HibernateRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional("administration-transaction_manager")
public class PgSqlBackofficeGroceryRepository extends HibernateRepository<BackofficeGrocery> implements BackofficeGroceryRepository {

    public PgSqlBackofficeGroceryRepository(@Qualifier("administration-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, BackofficeGrocery.class);
    }

    @Override
    public void save(BackofficeGrocery grocery) {
        persist(grocery);
    }

    @Override
    public List<BackofficeGrocery> searchAll() {
        return all();
    }

    @Override
    public List<BackofficeGrocery> matching(Criteria criteria) {
        return byCriteria(criteria);
    }
    
    @Override
    public Optional<BackofficeGrocery> search(BackofficeGroceryId id) {
        return byId(id);
    }
}
