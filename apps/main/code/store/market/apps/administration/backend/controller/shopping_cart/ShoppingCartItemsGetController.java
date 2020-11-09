package store.market.apps.administration.backend.controller.shopping_cart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import store.market.administration.shopping_cart_item.application.CartItemsResponse;
import store.market.administration.shopping_cart_item.application.search_by_criteria.SearchCartItemsByCriteriaQuery;
import store.market.shared.domain.DomainError;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.query.QueryBus;
import store.market.shared.domain.bus.query.QueryHandlerExecutionError;
import store.market.shared.infrastructure.spring.ApiController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public final class ShoppingCartItemsGetController extends ApiController{

	public ShoppingCartItemsGetController(QueryBus queryBus, CommandBus commandBus) {
		
		
		super(queryBus, commandBus);
	}
	

	@GetMapping("/shopping-cart-items/{session_id}")
    public List<HashMap<String, String>> index(@PathVariable String session_id) throws QueryHandlerExecutionError {
		HashMap<String, Serializable> params = new HashMap<String, Serializable>();
		
		params.put("filters[1][field]", "sessionId");
		params.put("filters[1][operator]", "=");
		params.put("filters[1][value]", session_id);
		
		CartItemsResponse items = ask(
	            new SearchCartItemsByCriteriaQuery(
	                    parseFilters(params),
	                    Optional.ofNullable((String) params.get("order_by")),
	                    Optional.ofNullable((String) params.get("order")),
	                    Optional.ofNullable((Integer) params.get("limit")),
	                    Optional.ofNullable((Integer) params.get("offset"))
	            )
	        );
		
        return items.items().stream().map(response -> new HashMap<String, String>() {{
            put("id", response.id());
            put("product_id", response.productId());
            put("product_name", response.productName());
            put("quantity", response.quantity().toString());
            put("price", response.productPrice().toString());
            put("amount_total", response.amountTotal().toString());
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
