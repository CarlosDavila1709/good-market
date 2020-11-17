package store.market.apps.backoffice.backend.controller.grocery;


import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import store.market.backoffice.grocery.application.GrocerysResponse;
import store.market.backoffice.grocery.application.search_all.SearchAllGrocerysQuery;

import store.market.shared.domain.DomainError;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.query.QueryBus;
import store.market.shared.domain.bus.query.QueryHandlerExecutionError;
import store.market.shared.infrastructure.spring.ApiController;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET })
public final class GrocerysAllGetController extends ApiController {

	public GrocerysAllGetController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@GetMapping("/grocerys-all")
	public List<HashMap<String, String>> index()
			throws QueryHandlerExecutionError {
		GrocerysResponse grocerys = ask(new SearchAllGrocerysQuery());

		return grocerys.grocerys().stream().map(response -> new HashMap<String, String>() {
			{
				put("id", response.id());
				put("nameCommercial", response.nameCommercial());
				put("address", response.address());
			}
		}).collect(Collectors.toList());
	}
	
    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}
