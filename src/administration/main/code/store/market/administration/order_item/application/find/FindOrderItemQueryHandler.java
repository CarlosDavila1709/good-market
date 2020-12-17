package store.market.administration.order_item.application.find;

import store.market.administration.order_item.application.OrderItemResponse;
import store.market.administration.order_item.domain.ItemId;
import store.market.administration.order_item.domain.ItemNotExist;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.query.QueryHandler;

@Service
public final class FindOrderItemQueryHandler implements QueryHandler<FindOrderItemQuery, OrderItemResponse>{

    private final OrderItemFinder finder;

    public FindOrderItemQueryHandler(OrderItemFinder finder) {
        this.finder = finder;
    }

    @Override
    public OrderItemResponse handle(FindOrderItemQuery query) throws ItemNotExist {
        return finder.find(new ItemId(query.id()));
    }
}
