package store.market.apps.administration.backend.controller.order;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import store.market.administration.order.application.update_status_order.UpdateStatusOrderCommand;

import store.market.shared.domain.DomainError;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.command.CommandHandlerExecutionError;
import store.market.shared.domain.bus.query.QueryBus;
import store.market.shared.infrastructure.spring.ApiController;

@RestController
public class OrdersUpdateStatusPutController extends ApiController{

	public OrdersUpdateStatusPutController(
			QueryBus queryBus,
            CommandBus commandBus) {
		 super(queryBus, commandBus);
	}
	
    @PutMapping(value = "/orders/{id}/status")
    public ResponseEntity<String> index(@PathVariable String id, @RequestBody RequestUpdate request
    ) throws CommandHandlerExecutionError {
    	
    	dispatch(new UpdateStatusOrderCommand(
    			id,
    			request.status()
            ));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}

final class RequestUpdate {

	private String status;
    
    public void setStatus(String status) {
        this.status = status;
    }
    public String status() {
    	return status;
    }
}
