package store.market.apps.administration.backend.controller.shopping_cart;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import store.market.administration.shopping_cart.application.add_product_to_card.AddProductShoppingCartCommand;

import store.market.shared.domain.DomainError;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.command.CommandHandlerExecutionError;
import store.market.shared.domain.bus.query.QueryBus;
import store.market.shared.infrastructure.spring.ApiController;

@RestController
public class ShoppingCartAddItemPutWebController  extends ApiController{

    public ShoppingCartAddItemPutWebController(
            QueryBus queryBus,
            CommandBus commandBus
        ) {
            super(queryBus, commandBus);
        }
    
    
    @PutMapping(value = "/shopping-cart/add")
    public ResponseEntity<String> index(@RequestBody Request request
    ) throws CommandHandlerExecutionError {
    	
    	dispatch(new AddProductShoppingCartCommand(
    			request.sessionId() ,
            	request.groceryId(),
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

final class Request {
    private String sessionId;
    private String groceryId;
    private String productId;
    private int quantity;
    
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    
    public void setGroceryId(String groceryId) {
        this.groceryId = groceryId;
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
    public String groceryId() {
    	return groceryId;
    }
    public String productId() {
    	return productId;
    }
    public int quantity() {
    	return quantity;
    }
}