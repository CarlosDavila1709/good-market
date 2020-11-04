package store.market.administration.shopping_cart_item.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import store.market.administration.shopping_cart_item.domain.CartItem;
import store.market.administration.shopping_cart_item.domain.CartItemId;
import store.market.administration.shopping_cart_item.domain.ItemCartRepository;
import store.market.shared.domain.Service;
import store.market.shared.domain.criteria.Criteria;
import store.market.shared.infrastructure.hibernate.HibernateRepository;

@Service
@Transactional("administration-transaction_manager")
public class PgSqlShoppingCartItemRepository extends HibernateRepository<CartItem> implements ItemCartRepository{

    public PgSqlShoppingCartItemRepository(@Qualifier("administration-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, CartItem.class);
    }
    
    @Override
    public void save(CartItem cartItem) {

    	persist(cartItem);
    }

    @Override
    public List<CartItem> matching(Criteria criteria) {
        return byCriteria(criteria);
    }

	@Override
	public List<CartItem> searchAll(String shoppingId) {

		return all();

	}

	@Override
	public Optional<CartItem> search(CartItemId cartItemId) {
		return byId(cartItemId);
	}
}
