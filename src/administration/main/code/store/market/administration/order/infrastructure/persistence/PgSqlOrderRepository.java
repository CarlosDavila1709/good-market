package store.market.administration.order.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import store.market.administration.order.domain.Order;
import store.market.administration.order.domain.OrderId;
import store.market.administration.order.domain.OrderRepository;
import store.market.shared.domain.Service;
import store.market.shared.domain.criteria.Criteria;
import store.market.shared.infrastructure.hibernate.HibernateRepository;

@Service
@Transactional("administration-transaction_manager")
public class PgSqlOrderRepository extends HibernateRepository<Order> implements OrderRepository{

	public PgSqlOrderRepository(@Qualifier("administration-session_factory") SessionFactory sessionFactory) {
		
		super(sessionFactory, Order.class);
		
	}

	@Override
	public void save(Order order) {
		
		persist(order);
		
	}

	@Override
	public Optional<Order> search(OrderId id) {
		
		return byId(id);
	}

	@Override
	public List<Order> matching(Criteria criteria) {
		
		return byCriteria(criteria);
	}

}
