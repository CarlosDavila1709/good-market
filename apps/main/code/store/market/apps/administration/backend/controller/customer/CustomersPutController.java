package store.market.apps.administration.backend.controller.customer;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import store.market.administration.customer.application.create.CreateCustomerCommand;
import store.market.shared.domain.DomainError;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.command.CommandHandlerExecutionError;
import store.market.shared.domain.bus.query.QueryBus;
import store.market.shared.infrastructure.spring.ApiController;

@RestController
public class CustomersPutController extends ApiController {

	public CustomersPutController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}
	
    @PutMapping(value = "/customers/{id}")
    public ResponseEntity<String> index(@PathVariable String id, @RequestBody Request request ) throws CommandHandlerExecutionError 
	{
    	dispatch( new CreateCustomerCommand(id, 
    			request.phone(), 
    			request.firstName(), 
    			request.lastName(), 
    			request.middleName(), 
    			request.address()));
    	return new ResponseEntity<>(HttpStatus.CREATED);
	}
    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
    
    
}

final class Request {

	private String firstName;
	private String lastName;
	private String middleName;
	private String phone;
	private String address;

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	String firstName() {
		return firstName;
	}
	String lastName() {
		return lastName;
	}
	String middleName() {
		return middleName;
	}
	String phone() {
		return phone;
	}
	String address() {
		return address;
	}

}