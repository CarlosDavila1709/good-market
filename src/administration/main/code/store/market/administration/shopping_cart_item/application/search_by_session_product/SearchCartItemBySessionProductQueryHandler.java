package store.market.administration.shopping_cart_item.application.search_by_session_product;

import store.market.administration.shopping_cart_item.application.CartItemsResponse;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.query.QueryHandler;

@Service
public class SearchCartItemBySessionProductQueryHandler implements QueryHandler<SearchCartItemBySessionProductQuery, CartItemsResponse>{

	private final CartItemBySessionProductSearcher searcher;
	
	public SearchCartItemBySessionProductQueryHandler(CartItemBySessionProductSearcher searcher) {
		
		this.searcher = searcher;
	}
	
    @Override
    public CartItemsResponse handle(SearchCartItemBySessionProductQuery query) {
        
	   return searcher.search(query.sessionId(),query.productId());
	   
    }
}
