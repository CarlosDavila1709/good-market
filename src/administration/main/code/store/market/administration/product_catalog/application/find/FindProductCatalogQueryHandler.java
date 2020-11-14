package store.market.administration.product_catalog.application.find;

import store.market.administration.product_catalog.application.ProductCatalogResponse;
import store.market.administration.product_catalog.domain.ProductCatalogId;
import store.market.administration.product_catalog.domain.ProductCatalogNotExist;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.query.QueryHandler;

@Service
public final class FindProductCatalogQueryHandler implements QueryHandler<FindProductCatalogQuery, ProductCatalogResponse>{

    private final ProductCatalogFinder finder;
    
    public FindProductCatalogQueryHandler(ProductCatalogFinder finder) {
    	
    	this.finder = finder;
    }
	@Override
	public ProductCatalogResponse handle(FindProductCatalogQuery query)  throws ProductCatalogNotExist {
		return finder.find(new ProductCatalogId(query.id()));
	}

}
