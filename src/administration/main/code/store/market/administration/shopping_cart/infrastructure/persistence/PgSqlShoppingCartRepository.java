package store.market.administration.shopping_cart.infrastructure.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import store.market.administration.shopping_cart.domain.ShoppingCart;
import store.market.administration.shopping_cart.domain.ShoppingCartId;
import store.market.administration.shopping_cart.domain.ShoppingCartRepository;
import store.market.administration.shopping_cart.domain.ShoppingCartSessionId;
import store.market.shared.domain.Service;
import store.market.shared.domain.criteria.Criteria;
import store.market.shared.domain.criteria.Filter;
import store.market.shared.domain.criteria.Filters;
import store.market.shared.domain.criteria.Order;
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

	@Override
	public Optional<ShoppingCart> searchSession(ShoppingCartSessionId id) {
		Filters filters = filtersSession(id);
        Criteria criteria = new Criteria(
        		filters,
                Order.none(),
                Optional.empty(),
                Optional.empty()
            );
		
        List<ShoppingCart> carts = byCriteria(criteria);
        return 0 ==  carts.size() ? Optional.empty() : Optional.ofNullable(carts.get(0));
	}
    private Filters filtersSession(ShoppingCartSessionId sessionId) {
		
    	Filter filterSession = Filter.create("sessionId", "=", sessionId.value());

		List<Filter> filtersList = new ArrayList<Filter>();
		filtersList.add(filterSession);
		
		return new Filters(filtersList);
    }
}
