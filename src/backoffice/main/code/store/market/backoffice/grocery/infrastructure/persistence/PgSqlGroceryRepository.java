package store.market.backoffice.grocery.infrastructure.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import store.market.backoffice.grocery.domain.Grocery;
import store.market.backoffice.grocery.domain.GroceryId;
import store.market.backoffice.grocery.domain.GroceryRepository;
import store.market.shared.domain.Service;
import store.market.shared.domain.criteria.Criteria;
import store.market.shared.infrastructure.hibernate.HibernateRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional("backoffice-transaction_manager")
public class PgSqlGroceryRepository extends HibernateRepository<Grocery> implements GroceryRepository{

	public PgSqlGroceryRepository(@Qualifier("backoffice-session_factory") SessionFactory sessionFactory) {
		super(sessionFactory,Grocery.class);
	}
	
    @Override
    public void save(Grocery grocery) {
        persist(grocery);
    }

    @Override
    public Optional<Grocery> search(GroceryId id) {
        return byId(id);
    }

    @Override
    public List<Grocery> matching(Criteria criteria) {
        return byCriteria(criteria);
    }
}
