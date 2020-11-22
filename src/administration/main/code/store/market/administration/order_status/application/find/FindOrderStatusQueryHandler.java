package store.market.administration.order_status.application.find;

import store.market.administration.order_status.application.StatusOrderResponse;
import store.market.administration.order_status.domain.OrderStatusNotExist;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.query.QueryHandler;

@Service
public final class FindOrderStatusQueryHandler implements QueryHandler<FindOrderStatusQuery, StatusOrderResponse>{

    private final OrderStatusFinder finder;

    public FindOrderStatusQueryHandler(OrderStatusFinder finder) {
        this.finder = finder;
    }

    @Override
    public StatusOrderResponse handle(FindOrderStatusQuery query) throws OrderStatusNotExist {

    	return finder.find(query.id());
    }
}
