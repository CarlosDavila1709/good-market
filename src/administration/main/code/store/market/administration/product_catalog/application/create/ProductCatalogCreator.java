package store.market.administration.product_catalog.application.create;

import store.market.administration.categorie.application.CategorieResponse;
import store.market.administration.categorie.application.find.FindCategorieQuery;
import store.market.administration.product.application.ProductResponse;
import store.market.administration.product.application.find.FindProductQuery;
import store.market.administration.product_catalog.domain.ProductCatalog;
import store.market.administration.product_catalog.domain.ProductCatalogId;
import store.market.administration.product_catalog.domain.ProductCatalogRepository;
import store.market.administration.unit_measure.application.UnitMeasureResponse;
import store.market.administration.unit_measure.application.find.FindUnitMeasureQuery;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.query.QueryBus;

@Service
public final class ProductCatalogCreator {

	private final ProductCatalogRepository repository;
	
    private final QueryBus queryBus;
	
	public ProductCatalogCreator(ProductCatalogRepository repository, QueryBus queryBus) {
		
		this.repository = repository;
		this.queryBus = queryBus;
		
	}
	
	public void create(String id) {
		
		ProductResponse product = queryBus.ask(new FindProductQuery(id));

		CategorieResponse categorie = queryBus.ask(new FindCategorieQuery(product.categorieId()));
		
		UnitMeasureResponse unitMeasure = queryBus.ask(new FindUnitMeasureQuery(product.unitMeasureId()));
		
		this.repository.save(new ProductCatalog(
				new ProductCatalogId(product.id()),
				product.name(), 
				categorie.id(), 
				categorie.name(), 
				unitMeasure.id(),
				product.groceryId(),
				unitMeasure.name(), 
				product.price()));
	}
}
