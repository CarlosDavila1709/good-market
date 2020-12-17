package store.market.apps.administration.backend.controller.order_items;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import store.market.administration.order.application.add_product_to_order.AddProductOrderCommand;
import store.market.shared.domain.DomainError;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.command.CommandHandlerExecutionError;
import store.market.shared.domain.bus.query.QueryBus;
import store.market.shared.infrastructure.spring.ApiController;

@RestController
public class OrderAddItemsPutController extends ApiController{

    public OrderAddItemsPutController(QueryBus queryBus,CommandBus commandBus) {
       super(queryBus, commandBus);
    }
    
    @PutMapping(value = "/orders/{id}/items")
    public ResponseEntity<String> index(@PathVariable String id, @RequestBody ItemRequest request ) throws CommandHandlerExecutionError 
	{
    	dispatch(
    			new AddProductOrderCommand(
    					id,
    					request.productId(),
    					request.quantity())
    			);
    	return new ResponseEntity<>(HttpStatus.OK);
	}
    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
 
}

final class ItemRequest {
	
	private String productId;
	private Integer quantity;
	
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String productId() {
		return productId;
	}
	public Integer quantity() {
		return quantity;
	}
}