package store.market.administration.shopping_cart_item.application.search_by_criteria;

import store.market.administration.shopping_cart_item.application.CartItemsResponse;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.query.QueryHandler;
import store.market.shared.domain.criteria.Filters;
import store.market.shared.domain.criteria.Order;

@Service
public final class SearchCartItemsByCriteriaQueryHandler implements QueryHandler<SearchCartItemsByCriteriaQuery, CartItemsResponse> {

    private final CartItemsByCriteriaSearcher searcher;

    public SearchCartItemsByCriteriaQueryHandler(CartItemsByCriteriaSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public CartItemsResponse handle(SearchCartItemsByCriteriaQuery query) {
        Filters filters = Filters.fromValues(query.filters());
        Order   order   = Order.fromValues(query.orderBy(), query.orderType());

        return searcher.search(filters, order, query.limit(), query.offset());
    }
}
