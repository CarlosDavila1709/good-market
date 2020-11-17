package store.market.apps.administration.backend.controller.grocery;

import java.io.Serializable;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import store.market.administration.grocery.application.BackofficeGroceryResponse;
import store.market.administration.grocery.application.find.FindBackofficeGroceryQuery;
import store.market.administration.grocery.domain.BackofficeGroceryNotExist;
import store.market.shared.domain.DomainError;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.query.QueryBus;
import store.market.shared.domain.bus.query.QueryHandlerExecutionError;
import store.market.shared.infrastructure.spring.ApiController;

@RestController
public final class GroceryGetController extends ApiController{

	public GroceryGetController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}
	
	@GetMapping("/grocerys/{id}")
	public ResponseEntity<HashMap<String, Serializable>> index(@PathVariable String id)
			throws QueryHandlerExecutionError {
		
		BackofficeGroceryResponse grocery = ask(new FindBackofficeGroceryQuery(id));

		return ResponseEntity.ok().body(new HashMap<String, Serializable>() {
			{
				put("id", grocery.id());
				put("firstName", grocery.active());
				put("lastName", grocery.address());
				put("middleName", grocery.nameCommercial());
			}
		});
	}
	
	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return new HashMap<Class<? extends DomainError>, HttpStatus>() {
			{
				put(BackofficeGroceryNotExist.class, HttpStatus.NOT_FOUND);
			}
		};
	}
}
