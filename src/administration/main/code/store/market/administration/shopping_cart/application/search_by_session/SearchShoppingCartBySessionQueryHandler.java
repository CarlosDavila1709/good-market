package store.market.administration.shopping_cart.application.search_by_session;

import store.market.administration.shopping_cart.application.ShoppingCartResponse;
import store.market.administration.shopping_cart.application.ShoppingCartsResponse;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.query.QueryHandler;

@Service
public final class SearchShoppingCartBySessionQueryHandler implements QueryHandler<SearchShoppingCartBySessionQuery, ShoppingCartResponse> {

	private final ShoppingCartBySessionSearcher searcher;
	
	public SearchShoppingCartBySessionQueryHandler(ShoppingCartBySessionSearcher searcher) {
		
		this.searcher = searcher;
	}
	
    @Override
    public ShoppingCartResponse handle(SearchShoppingCartBySessionQuery query) {
        
	   return searcher.search(query.sessionId());
	   
    }
}
