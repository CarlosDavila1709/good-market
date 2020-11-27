package store.market.apps.administration.backend.controller.categorie;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import store.market.administration.categorie.application.create.CreateCategorieCommand;
import store.market.shared.domain.DomainError;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.command.CommandHandlerExecutionError;
import store.market.shared.domain.bus.query.QueryBus;
import store.market.shared.infrastructure.spring.ApiController;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.PUT})
public class CategoriesPutController extends ApiController{

    public CategoriesPutController(
            QueryBus queryBus,
            CommandBus commandBus
        ) {
            super(queryBus, commandBus);
        }
    
    @PutMapping(value = "/categories/{id}")
    public ResponseEntity<String> index(@PathVariable String id, @RequestBody Request request
    ) throws CommandHandlerExecutionError {

		dispatch(new CreateCategorieCommand(
	            id,
	            request.groceryId(),
	            request.name()
	        ));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    
    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}

final class Request {

    private String groceryId;
    private String name;

    public void setGroceryId(String groceryId) {
        this.groceryId = groceryId;
    }
    public void setName(String name) {
        this.name = name;
    }

    String name() {
        return name;
    }
    
    String groceryId() {
        return groceryId;
    }
}