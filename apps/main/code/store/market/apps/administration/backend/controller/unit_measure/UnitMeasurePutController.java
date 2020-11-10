package store.market.apps.administration.backend.controller.unit_measure;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import store.market.administration.unit_measure.application.create.CreateUnitMeasureCommand;

import store.market.shared.domain.DomainError;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.command.CommandHandlerExecutionError;
import store.market.shared.domain.bus.query.QueryBus;
import store.market.shared.infrastructure.spring.ApiController;

public class UnitMeasurePutController extends ApiController{

    public UnitMeasurePutController(
            QueryBus queryBus,
            CommandBus commandBus
        ) {
            super(queryBus, commandBus);
        }
    
    @PutMapping(value = "/unitmeasures/{id}")
    public ResponseEntity<String> index(@PathVariable String id, @RequestBody Request request
    ) throws CommandHandlerExecutionError {
    	
    	dispatch(new CreateUnitMeasureCommand(
                id,
                request.groceryId,
                request.name,
                request.prefix
            ));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
    
    final class Request {

        private String groceryId;
        private String name;
        private String prefix;

        public void setGroceryId(String groceryId) {
            this.groceryId = groceryId;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void prefix(String prefix) {
            this.prefix = prefix;
        }
        String name() {
            return name;
        }
        String groceryId() {
            return groceryId;
        }
        String prefix() {
            return prefix;
        }
    }
}
