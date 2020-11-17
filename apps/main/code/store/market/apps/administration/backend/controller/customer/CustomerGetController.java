package store.market.apps.administration.backend.controller.customer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import store.market.administration.customer.application.CustomerResponse;
import store.market.administration.customer.application.find.FindCustomerQuery;
import store.market.administration.customer.domain.CustomerNotExist;
import store.market.shared.domain.DomainError;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.query.QueryBus;
import store.market.shared.domain.bus.query.QueryHandlerExecutionError;
import store.market.shared.infrastructure.spring.ApiController;

import java.io.Serializable;
import java.util.HashMap;

@RestController
public final class CustomerGetController extends ApiController {

	public CustomerGetController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@GetMapping("/customers/{id}")
	public ResponseEntity<HashMap<String, Serializable>> index(@PathVariable String id)
			throws QueryHandlerExecutionError {
		CustomerResponse customer = ask(new FindCustomerQuery(id));

		return ResponseEntity.ok().body(new HashMap<String, Serializable>() {
			{
				put("id", customer.id());
				put("firstName", customer.customerFirstName());
				put("lastName", customer.customerLastName());
				put("middleName", customer.customerMiddleName());
				put("phone", customer.customerPhone());
				put("address", customer.customerAddress());
			}
		});
	}

	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return new HashMap<Class<? extends DomainError>, HttpStatus>() {
			{
				put(CustomerNotExist.class, HttpStatus.NOT_FOUND);
			}
		};
	}
}
