package store.market.apps.backoffice.backend.controller.grocery;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import store.market.backoffice.grocery.application.create.CreateGroceryCommand;
import store.market.shared.domain.DomainError;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.command.CommandHandlerExecutionError;
import store.market.shared.domain.bus.query.QueryBus;
import store.market.shared.infrastructure.spring.ApiController;

@RestController
public final class GroceryPutController extends ApiController {

	public GroceryPutController(QueryBus queryBus, CommandBus commandBus) {

		super(queryBus, commandBus);

	}

    @PutMapping(value = "/grocerys/{id}")
	public ResponseEntity<String> index(
	        @PathVariable String id,
	        @RequestBody Request request) throws CommandHandlerExecutionError  {
		
    	dispatch(new CreateGroceryCommand(id, request.nameCommercial, request.address, request.active));
    	
    	return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return null;
	}
	
	final class Request{
		
		private String nameCommercial;
		private String address;
		private String active;
		
		public String getNameCommercial() {
			return nameCommercial;
		}
		public void setNameCommercial(String nameCommercial) {
			this.nameCommercial = nameCommercial;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getActive() {
			return active;
		}
		public void setActive(String active) {
			this.active = active;
		}
		
	}
}
