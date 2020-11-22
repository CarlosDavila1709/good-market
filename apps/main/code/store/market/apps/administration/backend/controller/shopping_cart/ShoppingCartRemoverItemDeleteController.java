package store.market.apps.administration.backend.controller.shopping_cart;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import store.market.administration.shopping_cart_item.application.remove.RemoveItemCommand;
import store.market.shared.domain.DomainError;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.command.CommandHandlerExecutionError;
import store.market.shared.domain.bus.query.QueryBus;
import store.market.shared.infrastructure.spring.ApiController;

@RestController
public class ShoppingCartRemoverItemDeleteController extends ApiController {

	public ShoppingCartRemoverItemDeleteController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@DeleteMapping(value = "/shopping-cart/item/{id}")
	public ResponseEntity<String> index(@PathVariable String id) throws CommandHandlerExecutionError {

		dispatch(new RemoveItemCommand(id));
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return null;
	}
}
