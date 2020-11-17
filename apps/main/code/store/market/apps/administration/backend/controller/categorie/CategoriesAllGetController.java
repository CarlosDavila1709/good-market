package store.market.apps.administration.backend.controller.categorie;

import java.util.HashMap;
import java.util.List;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import store.market.administration.categorie.application.CategoriesResponse;
import store.market.administration.categorie.application.search_all.SearchAllCategoriesQuery;
import store.market.shared.domain.DomainError;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.query.QueryBus;
import store.market.shared.domain.bus.query.QueryHandlerExecutionError;
import store.market.shared.infrastructure.spring.ApiController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public final class CategoriesAllGetController extends ApiController{

	public CategoriesAllGetController(QueryBus queryBus, CommandBus commandBus) {
		
		super(queryBus, commandBus);
	}
	
    @SuppressWarnings("serial")
	@GetMapping("/categories-all")
    public List<HashMap<String, String>> index() throws QueryHandlerExecutionError {

        CategoriesResponse categories = ask(
                new SearchAllCategoriesQuery()
            );

            return categories.categories().stream().map(response -> new HashMap<String, String>() {{
                put("id", response.id());
                put("name", response.name());
            }}).collect(Collectors.toList());
    }
    
    
    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}