package store.market.apps.administration.backend.controller.order_status;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import store.market.administration.order.domain.OrderNotExist;
import store.market.administration.order_status.application.StatusOrdersResponse;
import store.market.administration.order_status.application.search_all.SearchAllStatusQuery;
import store.market.shared.domain.DomainError;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.query.QueryBus;
import store.market.shared.domain.bus.query.QueryHandlerExecutionError;
import store.market.shared.infrastructure.spring.ApiController;


@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public final class OrderStatusGetController extends ApiController{

	public OrderStatusGetController(QueryBus queryBus,CommandBus commandBus) {
		super(queryBus,commandBus);
	}
	
	@GetMapping("/orders-status")
	public List<HashMap<String, String>> index()
			throws QueryHandlerExecutionError {
		
		StatusOrdersResponse status = ask(new SearchAllStatusQuery());

            return status.statusOrders().stream().map(response -> new HashMap<String, String>() {{
                put("codigo", response.codigo());
                put("description", response.description());
            }}).collect(Collectors.toList());
	}
	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return new HashMap<Class<? extends DomainError>, HttpStatus>() {
			{
				put(OrderNotExist.class, HttpStatus.NOT_FOUND);
			}
		};
	}
}
