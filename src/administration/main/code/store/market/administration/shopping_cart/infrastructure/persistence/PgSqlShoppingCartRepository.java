package store.market.administration.shopping_cart.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import store.market.administration.shopping_cart.domain.ShoppingCart;
import store.market.administration.shopping_cart.domain.ShoppingCartId;
import store.market.administration.shopping_cart.domain.ShoppingCartRepository;

import store.market.shared.domain.Service;
import store.market.shared.domain.criteria.Criteria;
import store.market.shared.infrastructure.hibernate.HibernateRepository;

@Service
@Transactional("administration-transaction_manager")
public class PgSqlShoppingCartRepository extends HibernateRepository<ShoppingCart> implements ShoppingCartRepository{

	public PgSqlShoppingCartRepository(@Qualifier("administration-session_factory") SessionFactory sessionFactory) {
		super(sessionFactory, ShoppingCart.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(ShoppingCart shoppingCart) {
		
		persist(shoppingCart);
		
	}

	@Override
	public List<ShoppingCart> searchAll() {
		
		return all();
	}

	@Override
	public List<ShoppingCart> matching(Criteria criteria) {
		
		return byCriteria(criteria);
	}

	@Override
	public Optional<ShoppingCart> search(ShoppingCartId id) {
		
		return byId(id);
	}

	
}
