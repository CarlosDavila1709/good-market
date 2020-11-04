package store.market.administration.shopping_cart_item.application.add_product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import store.market.administration.shopping_cart_item.domain.*;
import store.market.shared.domain.Service;
import store.market.shared.domain.UuidGenerator;
import store.market.shared.domain.bus.query.QueryBus;
import store.market.shared.domain.criteria.Criteria;
import store.market.shared.domain.criteria.Filter;
import store.market.shared.domain.criteria.Filters;
import store.market.shared.domain.criteria.Order;


@Service
public final class AddProductCart {

    private final ItemCartRepository repository;
    private final QueryBus      queryBus;
    private final UuidGenerator uuidGenerator;
    
    public AddProductCart(ItemCartRepository repository, QueryBus queryBus, UuidGenerator uuidGenerator) {
    	
    	this.repository = repository;
    	this.queryBus = queryBus;
    	this.uuidGenerator = uuidGenerator;
    }
     
    public void add(
    		ShoppingCartSessionId sessionId,
    		CartItemProductId productId,
    		CartItemProductPrice productPrice,
    		CartItemProductName productName,
    		CartItemQuantity quantity) {
    	
    	Filters filters = filtersSessionProduct( sessionId,  productId);
        Criteria criteria = new Criteria(
        		filters,
                Order.none(),
                Optional.empty(),
                Optional.empty()
            );

        List<CartItem> items = repository.matching(criteria);
        CartItem cartItem = null;
        
        if(items.size() > 1) {
        	
        	cartItem = items.get(0);
        	cartItem.increment(quantity);
        	repository.save(cartItem);

        }else {
        	
            cartItem = CartItem.create(new CartItemId(uuidGenerator.generate()),sessionId, productId, productPrice, productName,quantity);
        	
        }
        
        repository.save(cartItem);
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
