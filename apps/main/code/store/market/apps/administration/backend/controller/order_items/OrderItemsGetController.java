package store.market.apps.administration.backend.controller.order_items;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import store.market.administration.order_item.application.OrderItemsResponse;
import store.market.administration.order_item.application.search_by_order.SearchItemsByOrderQuery;
import store.market.shared.domain.DomainError;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.query.QueryBus;
import store.market.shared.domain.bus.query.QueryHandlerExecutionError;
import store.market.shared.infrastructure.spring.ApiController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public final class OrderItemsGetController extends ApiController{

	public OrderItemsGetController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}
	
	@GetMapping("/orders/{id}/items")
    public List<HashMap<String, String>> index(@PathVariable String id)throws QueryHandlerExecutionError{
		
		OrderItemsResponse items = ask( new SearchItemsByOrderQuery(id));
        return items.items().stream().map(response -> new HashMap<String, String>() {{
            put("id", response.id());
            put("orderId", response.orderId());
            put("amountTotal", response.amountTotal().toString());
            put("productId", response.productId());
            put("productName", response.productName());
            put("productPrice", response.productPrice().toString());
            put("quantity", response.quantity().toString());
            put("categorieName", response.categorieName());
            put("unitMeasureName", response.unitMeasureName());
        }}).collect(Collectors.toList());
	}
    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}
