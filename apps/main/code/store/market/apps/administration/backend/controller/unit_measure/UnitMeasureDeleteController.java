package store.market.apps.administration.backend.controller.unit_measure;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import store.market.administration.unit_measure.application.delete.UnitMeasureCommand;
import store.market.shared.domain.DomainError;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.command.CommandHandlerExecutionError;
import store.market.shared.domain.bus.query.QueryBus;
import store.market.shared.infrastructure.spring.ApiController;

@RestController
public class UnitMeasureDeleteController extends ApiController {

	public UnitMeasureDeleteController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}
	@DeleteMapping(value = "/unitmeasures/{id}")
	public ResponseEntity<String> index(@PathVariable String id) throws CommandHandlerExecutionError {

		dispatch(new UnitMeasureCommand(id));
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return null;
	}
}
