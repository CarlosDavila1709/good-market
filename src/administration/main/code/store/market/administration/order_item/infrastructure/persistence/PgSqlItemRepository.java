package store.market.administration.order_item.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import store.market.administration.order_item.domain.Item;
import store.market.administration.order_item.domain.ItemId;
import store.market.administration.order_item.domain.ItemRepository;
import store.market.shared.domain.Service;
import store.market.shared.domain.criteria.Criteria;
import store.market.shared.infrastructure.hibernate.HibernateRepository;

@Service
@Transactional("administration-transaction_manager")
public class PgSqlItemRepository extends HibernateRepository<Item> implements ItemRepository{

	public PgSqlItemRepository(@Qualifier("administration-session_factory") SessionFactory sessionFactory) {
		
		super(sessionFactory, Item.class);
		
	}

	@Override
	public void save(Item item) {
		persist(item);
	}

	@Override
	public Optional<Item> search(ItemId id) {
		
		return byId(id);
	}

	@Override
	public List<Item> matching(Criteria criteria) {
		
		return byCriteria(criteria);
	}

}
