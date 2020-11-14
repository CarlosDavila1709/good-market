package store.market.apps.administration.backend.controller.shopping_cart;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import store.market.administration.shopping_cart.application.ShoppingCartResponse;
import store.market.administration.shopping_cart.application.search_by_session_active.SearchShoppingCartBySessionQuery;
import store.market.administration.shopping_cart.domain.ShoppingCartNotExist;
import store.market.shared.domain.DomainError;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.query.QueryBus;
import store.market.shared.domain.bus.query.QueryHandlerExecutionError;
import store.market.shared.infrastructure.spring.ApiController;

import java.io.Serializable;
import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public final class ShoppingCartGetController extends ApiController {

	public ShoppingCartGetController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}


	@GetMapping("/shopping-carts")
	public ResponseEntity<HashMap<String, Serializable>> index(@RequestParam String  sessionid)
			throws QueryHandlerExecutionError {

		ShoppingCartResponse response = ask(new SearchShoppingCartBySessionQuery(sessionid));

		return ResponseEntity.ok().body(new HashMap<String, Serializable>() {
			{
				put("identificador", response.id());
				put("session_id", response.sessionId());
				put("amount_total", response.amountTotal());
				put("items_total", response.totalItems());
			}
		});
	}

	@SuppressWarnings("serial")
	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return new HashMap<Class<? extends DomainError>, HttpStatus>() {
			{
				put(ShoppingCartNotExist.class, HttpStatus.NOT_FOUND);
			}
		};
	}
}
