package store.market.apps.administration.backend.controller.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import store.market.administration.customer.application.CustomerResponse;
import store.market.administration.customer.application.search_by_phone.SearchCustomerByPhoneQuery;
import store.market.administration.customer.domain.CustomerNotExist;
import store.market.administration.order.application.OrdersResponse;
import store.market.administration.order.application.search_by_criteria.SearchOrdersByCriteriaQuery;
import store.market.shared.domain.DomainError;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.query.QueryBus;
import store.market.shared.domain.bus.query.QueryHandlerExecutionError;
import store.market.shared.infrastructure.spring.ApiController;

@RestController
public final class OrderAllByCustomerPhoneGetController extends ApiController{

	public OrderAllByCustomerPhoneGetController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@GetMapping("/orders/filter")
    public List<HashMap<String, String>> index(@RequestParam(value = "phoneCustomer") String phoneCustomer) throws QueryHandlerExecutionError {
		
		CustomerResponse customer = ask(new SearchCustomerByPhoneQuery(phoneCustomer));

		if(customer == null) {
			return null;
		}

		HashMap<String, Serializable> params = new HashMap<String, Serializable>();
		
		params.put("filters[1][field]", "customerId");
		params.put("filters[1][operator]", "=");
		params.put("filters[1][value]", customer.id());
		
        OrdersResponse orders = ask(
                new SearchOrdersByCriteriaQuery(
                        parseFilters(params),
                        Optional.ofNullable((String) params.get("order_by")),
                        Optional.ofNullable((String) params.get("order")),
                        Optional.ofNullable(params.get("limit") !=null ?Integer.parseInt((String) params.get("limit")): null),
                        Optional.ofNullable(params.get("offset") !=null ?Integer.parseInt((String) params.get("offset")): null)
                		)
            );

            return orders.orders().stream().map(response -> new HashMap<String, String>() {{
                put("id", response.id());
                put("customerId", response.customerId());
                put("groceryId", response.groceryId());
                put("dateCreation", response.dateCreation());
                put("amountTotal", response.amountTotal().toString());
                put("totalItems", response.totalItems().toString());
                put("nameCustomer", response.nameCustomer().toString());
                put("codigoStatus", response.codigoStatus().toString());
                put("descriptionStatus", response.descriptionStatus().toString());
            }}).collect(Collectors.toList());
	}
	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return new HashMap<Class<? extends DomainError>, HttpStatus>() {
			{
				put(CustomerNotExist.class, HttpStatus.NOT_FOUND);
			}
		};
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
