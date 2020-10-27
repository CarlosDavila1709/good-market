package store.market.apps.administration.backend.controller.grocery;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import store.market.administration.grocery.application.BackofficeGrocerysResponse;
import store.market.administration.grocery.application.search_by_criteria.SearchBackofficeGrocerysByCriteriaQuery;
import store.market.shared.domain.DomainError;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.query.QueryBus;
import store.market.shared.domain.bus.query.QueryHandlerExecutionError;
import store.market.shared.infrastructure.spring.ApiController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public final class GrocerysGetController extends ApiController {

	public GrocerysGetController(QueryBus queryBus, CommandBus commandBus) {
		
		super(queryBus, commandBus);
	}
	
    @GetMapping("/grocerys")
    public List<HashMap<String, String>> index(
        @RequestParam HashMap<String, Serializable> params
    ) throws QueryHandlerExecutionError {
    
    	//{filters[0][value]=DACA, filters[0][field]=nameCommercial, filters[0][operator]==}
    	
    	params.put("filters[0][value]", "DACA05");
    	params.put("filters[0][field]", "nameCommercial");
    	params.put("filters[0][operator]", "=");
    	
        BackofficeGrocerysResponse grocerys = ask(
                new SearchBackofficeGrocerysByCriteriaQuery(
                    parseFilters(params),
                    Optional.ofNullable((String) params.get("order_by")),
                    Optional.ofNullable((String) params.get("order")),
                    Optional.ofNullable((Integer) params.get("limit")),
                    Optional.ofNullable((Integer) params.get("offset"))
                )
            );

            return grocerys.grocerys().stream().map(response -> new HashMap<String, String>() {{
                put("id", response.id());
                put("nameCommercial", response.nameCommercial());
                put("address", response.address());
                put("active", response.active());
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
