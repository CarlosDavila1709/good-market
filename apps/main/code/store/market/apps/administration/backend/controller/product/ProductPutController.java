package store.market.apps.administration.backend.controller.product;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import store.market.administration.product.application.create.CreateProductCommand;
import store.market.shared.domain.DomainError;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.command.CommandHandlerExecutionError;
import store.market.shared.domain.bus.query.QueryBus;
import store.market.shared.infrastructure.spring.ApiController;

import java.util.HashMap;

@RestController
public class ProductPutController extends ApiController{

	public ProductPutController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
		
	}

    @PutMapping(value = "/products/{id}")
    public ResponseEntity<String> index(@PathVariable String id, @RequestBody Request request
    ) throws CommandHandlerExecutionError {
    	
    	dispatch(new CreateProductCommand(
                id,
                request.categorieId,
                request.measureId,
                request.groceryId,
                request.name,
                request.price
            ));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    
    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
    
    final class Request {
        private String groceryId;
    	private String categorieId;
        private String measureId;
        private String name;
        private Double price;

        public void setGroceryId(String groceryId) {
            this.groceryId = groceryId;
        }
        public void categorieId(String categorieId) {
            this.categorieId = categorieId;
        }
        public void measureId(String measureId) {
            this.measureId = measureId;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void price(Double price) {
            this.price = price;
        }
        
        String groceryId() {
            return groceryId;
        }
        String categorieId() {
            return categorieId;
        }
        String measureId() {
            return measureId;
        }
        String name() {
            return name;
        }
        Double price() {
            return price;
        }
    }
}
