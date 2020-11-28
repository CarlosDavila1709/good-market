package store.market.apps.administration.backend.controller.product_catalog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import store.market.administration.product_catalog.application.ProductsCatalogResponse;
import store.market.administration.product_catalog.application.search_by_criteria.SearchProductsCatalogByCriteriaQuery;
import store.market.shared.domain.DomainError;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.query.QueryBus;
import store.market.shared.domain.bus.query.QueryHandlerExecutionError;
import store.market.shared.infrastructure.spring.ApiController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public final class ProductsCatalogGetController  extends ApiController {


	public ProductsCatalogGetController(QueryBus queryBus, CommandBus commandBus) {
		
		super(queryBus, commandBus);
	}
	
    @SuppressWarnings("serial")
	@GetMapping("/products-catalog")
    public List<HashMap<String, String>> index(
            @RequestParam HashMap<String, Serializable> params
    		) throws QueryHandlerExecutionError {

        ProductsCatalogResponse products = ask(
                new SearchProductsCatalogByCriteriaQuery(
                        parseFilters(params),
                        Optional.ofNullable((String) params.get("order_by")),
                        Optional.ofNullable((String) params.get("order")),
                        Optional.ofNullable(params.get("limit") !=null ?Integer.parseInt((String) params.get("limit")): null),
                        Optional.ofNullable(params.get("offset") !=null ?Integer.parseInt((String) params.get("offset")): null)
                		)
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
    private List<HashMap<String, String>> parseFilters(HashMap<String, Serializable> params) {
        int maxParams = params.size();

        List<HashMap<String, String>> filters = new ArrayList<>();

        for (int possibleFilterKey = 0; possibleFilterKey < maxParams; possibleFilterKey++) {
            if (params.containsKey(String.format("filters[%s][field]", possibleFilterKey))) {
                int key = possibleFilterKey;

                filters.add(new HashMap<String, String>() {{
                    put("field", (String) params.get(String.format("filters[%s][field]", key)));
                    put("operator", (String) params.get(String.format("filters[%s][operator]", key)));
                    put("value", (String) params.get(String.format("filters[%s][value]", key)));
                }});
            }
        }

        return filters;
    }
}
