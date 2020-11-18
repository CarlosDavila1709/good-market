package store.market.apps.administration.backend.controller.shopping_cart;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import store.market.administration.shopping_cart.application.remove_product_to_cart.RemoveProductShoppingCartCommand;
import store.market.administration.shopping_cart_item.application.remove.RemoveItemCommand;
import store.market.shared.domain.DomainError;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.command.CommandHandlerExecutionError;
import store.market.shared.domain.bus.query.QueryBus;
import store.market.shared.infrastructure.spring.ApiController;

@RestController
public class ShoppingCartRemoverItemDeleteWebController extends ApiController {

	public ShoppingCartRemoverItemDeleteWebController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@DeleteMapping(value = "/shopping-cart/item")
	public ResponseEntity<String> index(@RequestBody RequestRemove request) throws CommandHandlerExecutionError {

		//dispatch(new RemoveItemCommand(id));
		dispatch(new RemoveProductShoppingCartCommand(request.sessionId(),request.productId()));
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return null;
	}
}
final class RequestRemove {
    
	private String sessionId;
	private String productId;
	
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    
    public String sessionId() {
    	return sessionId;
    }
    public String productId() {
    	return productId;
    }
}