package store.market.administration.product_catalog.application.search_by_categorie;

import store.market.administration.product_catalog.application.ProductsCatalogResponse;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.query.QueryHandler;

@Service
public final class SearchCategorieProductCatalogQueryHandler implements QueryHandler<SearchCategorieProductCatalogQuery, ProductsCatalogResponse>{

	private final CategorieProductCatalogSearcher searcher;
	
	public SearchCategorieProductCatalogQueryHandler(CategorieProductCatalogSearcher searcher) {
		
		this.searcher = searcher;
	}
	
    @Override
    public ProductsCatalogResponse handle(SearchCategorieProductCatalogQuery query) {
        
	   return searcher.search(query.categorieId());
	   
    }
}
