package store.market.administration.product_catalog.application.search_all;

import store.market.administration.product_catalog.application.ProductsCatalogResponse;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.query.QueryHandler;

@Service
public final class SearchAllProductsCatalogQueryHandler implements QueryHandler<SearchAllProductsCatalogQuery, ProductsCatalogResponse>{

	private final AllProductsCatalogSearch searcher;
	
    public SearchAllProductsCatalogQueryHandler(AllProductsCatalogSearch searcher) {
        this.searcher = searcher;
    }

    @Override
    public ProductsCatalogResponse handle(SearchAllProductsCatalogQuery query) {
        return searcher.search();
    }
}
