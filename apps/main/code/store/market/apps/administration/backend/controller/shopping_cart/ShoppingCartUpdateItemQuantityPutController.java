package store.market.apps.administration.backend.controller.shopping_cart;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import store.market.administration.shopping_cart_item.application.update_quantity.UpdateQuantityItemCommand;
import store.market.shared.domain.DomainError;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.command.CommandHandlerExecutionError;
import store.market.shared.domain.bus.query.QueryBus;
import store.market.shared.infrastructure.spring.ApiController;

@RestController
public class ShoppingCartUpdateItemQuantityPutController extends ApiController{

	public ShoppingCartUpdateItemQuantityPutController(
			QueryBus queryBus,
            CommandBus commandBus) {
		 super(queryBus, commandBus);
	}
	
    @PutMapping(value = "/shopping-cart/item/{id}")
    public ResponseEntity<String> index(@PathVariable String id, @RequestBody RequestUpdate request
    ) throws CommandHandlerExecutionError {
    	
    	dispatch(new UpdateQuantityItemCommand(
    			id,
    			request.quantity()
            ));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}

final class RequestUpdate {

	private Integer quantity;
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Integer quantity() {
    	return quantity;
    }
}
