package store.market.administration.order.application.find;

import store.market.administration.order.application.OrderResponse;
import store.market.administration.order.domain.OrderId;
import store.market.administration.order.domain.OrderNotExist;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.query.QueryHandler;

@Service
public class FindOrderQueryHandler implements QueryHandler<FindOrderQuery, OrderResponse>{

    private final OrderFinder finder;

    public FindOrderQueryHandler(OrderFinder finder) {
        this.finder = finder;
    }

    @Override
    public OrderResponse handle(FindOrderQuery query) throws OrderNotExist {
        return finder.find(new OrderId(query.id()));
    }
}
