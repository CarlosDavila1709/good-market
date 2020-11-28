package store.market.apps.administration.backend.controller.product_catalog;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import store.market.administration.product_catalog.application.ProductsCatalogResponse;
import store.market.administration.product_catalog.application.search_all.SearchAllProductsCatalogQuery;
import store.market.shared.domain.DomainError;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.query.QueryBus;
import store.market.shared.domain.bus.query.QueryHandlerExecutionError;
import store.market.shared.infrastructure.spring.ApiController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public final class ProductsAllCatalogGetController extends ApiController{

	public ProductsAllCatalogGetController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}
	
    @SuppressWarnings("serial")
	@GetMapping("/products-catalog/all")
    public List<HashMap<String, String>> index() throws QueryHandlerExecutionError {

        ProductsCatalogResponse products = ask(
                new SearchAllProductsCatalogQuery()
            );

            return products.products().stream().map(response -> new HashMap<String, String>() {{
                put("id", response.id());
                put("name", response.name());
                put("categorieId", response.categorieId());
                put("categorieName", response.categorieName());
                put("unitMeasureName", response.unitMeasureName());
                put("price", response.price().toString());
                put("unitMeasureId", response.unitMeasureId());
            }}).collect(Collectors.toList());
    }
    
    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}
