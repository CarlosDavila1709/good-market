package store.market.administration.product.application.find;

import store.market.administration.product.application.ProductResponse;
import store.market.administration.product.domain.ProductId;
import store.market.administration.product.domain.ProductNotExist;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.query.QueryHandler;

@Service
public final class FindProductQueryHandler  implements QueryHandler<FindProductQuery, ProductResponse> {

    private final ProductFinder finder;

    public FindProductQueryHandler(ProductFinder finder) {
        this.finder = finder;
    }

    @Override
    public ProductResponse handle(FindProductQuery query) throws ProductNotExist {
        return finder.find(new ProductId(query.id()));
    }
}
