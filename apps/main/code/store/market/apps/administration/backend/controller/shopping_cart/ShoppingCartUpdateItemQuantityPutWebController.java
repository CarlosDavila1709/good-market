package store.market.apps.administration.backend.controller.shopping_cart;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import store.market.administration.shopping_cart.application.update_quantity_product.UpdateProductQuantityCommand;

import store.market.shared.domain.DomainError;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.command.CommandHandlerExecutionError;
import store.market.shared.domain.bus.query.QueryBus;
import store.market.shared.infrastructure.spring.ApiController;

@RestController
public class ShoppingCartUpdateItemQuantityPutWebController extends ApiController{

	public ShoppingCartUpdateItemQuantityPutWebController(
			QueryBus queryBus,
            CommandBus commandBus) {
		 super(queryBus, commandBus);
	}
	
    @PutMapping(value = "/shopping-cart/item")
    public ResponseEntity<String> index(@RequestBody RequestUpdate request
    ) throws CommandHandlerExecutionError {
    	
    	dispatch(new UpdateProductQuantityCommand(
    			request.sessionId(),
    			request.productId(),
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
    
	private String sessionId;
	private String productId;
	private Integer quantity;
    
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String sessionId() {
    	return sessionId;
    }
    public String productId() {
    	return productId;
    }
    public Integer quantity() {
    	return quantity;
    }
}
