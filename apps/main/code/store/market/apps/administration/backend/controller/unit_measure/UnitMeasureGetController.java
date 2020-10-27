package store.market.apps.administration.backend.controller.unit_measure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import store.market.administration.unit_measure.application.UnitMeasuresResponse;
import store.market.administration.unit_measure.application.search_all.SearchAllUnitMeasuresQuery;
import store.market.shared.domain.DomainError;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.query.QueryBus;
import store.market.shared.domain.bus.query.QueryHandlerExecutionError;
import store.market.shared.infrastructure.spring.ApiController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public final class UnitMeasureGetController extends ApiController{

	public UnitMeasureGetController(QueryBus queryBus, CommandBus commandBus) {
		
		super(queryBus, commandBus);
	}
	
    @GetMapping("/unitmeasures")
    public List<HashMap<String, String>> index() throws QueryHandlerExecutionError {

        UnitMeasuresResponse measures = ask(
                new SearchAllUnitMeasuresQuery()
            );

            return measures.unitMeasures.stream().map(response -> new HashMap<String, String>() {{
                put("id", response.id());
                put("name", response.name());
                put("prefix", response.prefix());
            }}).collect(Collectors.toList());
    }
    
    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
    private List<HashMap<String, String>> parseFilters(HashMap<String, Serializable> params) {
        int maxParams = params.size();

        List<HashMap<String, String>> filters = new ArrayList<>();

        for (int possibleFilterKey = 0; possibleFilterKey < maxParams; possibleFilterKey++) {
            if (params.containsKey(String.format("filters[%s][field]", possibleFilterKey))) {
                int key = possibleFilterKey;

                filters.add(new HashMap<String, String>() {{
                    put("field", (String) params.get(String.format("filters[%s][field]", key)));
                    put("operator", (String) params.get(String.format("filters[%s][operator]", key)));
                    put("value", (String) params.get(String.format("filters[%s][value]", key)));
                }});
            }
        }

        return filters;
    }
}
