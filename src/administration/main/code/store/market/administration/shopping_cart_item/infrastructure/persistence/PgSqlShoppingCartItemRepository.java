package store.market.administration.shopping_cart_item.infrastructure.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import store.market.administration.shopping_cart_item.domain.CartItem;
import store.market.administration.shopping_cart_item.domain.CartItemId;
import store.market.administration.shopping_cart_item.domain.CartItemProductId;
import store.market.administration.shopping_cart_item.domain.ItemCartRepository;
import store.market.administration.shopping_cart_item.domain.ShoppingCartSessionId;
import store.market.shared.domain.Service;
import store.market.shared.domain.criteria.Criteria;
import store.market.shared.domain.criteria.Filter;
import store.market.shared.domain.criteria.Filters;
import store.market.shared.domain.criteria.Order;
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
    public void delete(CartItem cartItem) {

    	remover(cartItem);
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
	

	@Override
	public Optional<CartItem> search(ShoppingCartSessionId sessionId, CartItemProductId productId) {
		Filters filters = filtersSessionProduct(sessionId,productId);
        Criteria criteria = new Criteria(
        		filters,
                Order.none(),
                Optional.empty(),
                Optional.empty()
            );
		
        List<CartItem> items = byCriteria(criteria);
        return 0 ==  items.size() ? Optional.empty() : Optional.ofNullable(items.get(0));
	}
    private Filters filtersSessionProduct(ShoppingCartSessionId sessionId, CartItemProductId productId) {
		
    	Filter filterSession = Filter.create("sessionId", "=", sessionId.value());
		Filter filterProduct = Filter.create("productId", "=", productId.value());
		
		List<Filter> filtersList = new ArrayList<Filter>();
		filtersList.add(filterSession);
		filtersList.add(filterProduct);
		
		return new Filters(filtersList);
    }
}
