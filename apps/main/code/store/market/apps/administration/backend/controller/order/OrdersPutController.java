package store.market.apps.administration.backend.controller.order;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import store.market.administration.order.application.create.CreateOrderCommand;
import store.market.shared.domain.DomainError;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.command.CommandHandlerExecutionError;
import store.market.shared.domain.bus.query.QueryBus;
import store.market.shared.infrastructure.spring.ApiController;

@RestController
public class OrdersPutController extends ApiController {

	public OrdersPutController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}
	
    @PutMapping(value = "/orders/{id}")
    public ResponseEntity<String> index(@PathVariable String id, @RequestBody Request request ) throws CommandHandlerExecutionError 
	{
    	dispatch(
    			new CreateOrderCommand(
    					id,
    					request.sessionId(),
    					request.customer().id()
    					)
    			);
    	return new ResponseEntity<>(HttpStatus.CREATED);
	}
    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}

final class Request {

	private String sessionId;	
	private CustomerRequest customer;

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	String sessionId() {
		return sessionId;
	}
	
	public void setCustomer(CustomerRequest customer) {
		this.customer = customer;
	}

	CustomerRequest customer() {
		return customer;
	}

}

final class CustomerRequest {
	
	private String id;

	public void setId(String id) {
		this.id = id;
	}
	String id() {
		return id;
	}

}
