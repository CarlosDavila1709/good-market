package store.market.apps.administration.backend.controller.order_items;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import store.market.administration.order.application.remove_product_to_order.RemoveItemToOrderCommand;

import store.market.shared.domain.DomainError;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.command.CommandHandlerExecutionError;
import store.market.shared.domain.bus.query.QueryBus;
import store.market.shared.infrastructure.spring.ApiController;

@RestController
public class OrderRemoverItemDeleteController extends ApiController{

	public OrderRemoverItemDeleteController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}
	@DeleteMapping(value = "/orders/{orderid}/items/{itemid}")
	public ResponseEntity<String> index(@PathVariable String orderid,@PathVariable String itemid) throws CommandHandlerExecutionError {

		dispatch(new RemoveItemToOrderCommand(orderid,itemid));
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return null;
	}
}
