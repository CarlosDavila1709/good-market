package store.market.administration.shopping_cart_item.application.search_by_cart;

import store.market.administration.shopping_cart_item.application.CartItemsResponse;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.query.QueryHandler;

@Service
public final class SearchCartItemByCartQueryHandler implements QueryHandler<SearchCartItemByCartQuery, CartItemsResponse>{

	private final CartItemByCartSearcher searcher;
	
	public SearchCartItemByCartQueryHandler(CartItemByCartSearcher searcher) {
		
		this.searcher = searcher;
	}
	
    @Override
    public CartItemsResponse handle(SearchCartItemByCartQuery query) {
        
	   return searcher.search(query.shoppingCartId());
	   
    }
}
