package store.market.apps.administration.backend.controller.order;

import java.io.Serializable;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import store.market.administration.order.application.OrderResponse;
import store.market.administration.order.application.find.FindOrderQuery;
import store.market.administration.order.domain.OrderNotExist;
import store.market.shared.domain.DomainError;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.query.QueryBus;
import store.market.shared.domain.bus.query.QueryHandlerExecutionError;
import store.market.shared.infrastructure.spring.ApiController;

@RestController
public final class OrderGetController extends ApiController{

	public OrderGetController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}
	
	@GetMapping("/orders/{id}")
	public ResponseEntity<HashMap<String, Serializable>> index(@PathVariable String id)
			throws QueryHandlerExecutionError {
		OrderResponse order = ask(new FindOrderQuery(id));

		return ResponseEntity.ok().body(new HashMap<String, Serializable>() {
			{
				put("id", order.id());
				put("amountTotal", order.amountTotal());
				put("customerId", order.customerId());
				put("dateCreation", order.dateCreation());
				put("groceryId", order.groceryId());
				put("totalItems", order.totalItems());
			}
		});
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
