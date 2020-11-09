package store.market.apps.webstore.frontend.controller.shopping_cart;

import java.io.Serializable;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import store.market.administration.shopping_cart.application.ShoppingCartResponse;
import store.market.administration.shopping_cart.application.search_by_session.SearchShoppingCartBySessionQuery;
import store.market.apps.webstore.frontend.controller.abstract_controller.AbstractSessionesController;
import store.market.shared.domain.bus.query.QueryBus;

@Controller
public final class ShoppingCartGetWebController extends AbstractSessionesController{

	private static final long serialVersionUID = -1910180290709869486L;
	
	private final QueryBus queryBus;
	
	public ShoppingCartGetWebController(QueryBus queryBus) {

		this.queryBus = queryBus;
	}
	
    @SuppressWarnings("serial")
	@GetMapping("/shopping-carts")
    public ModelAndView index(HttpSession session) {
    	
    	ShoppingCartResponse response = queryBus.ask(new SearchShoppingCartBySessionQuery(sessionId(session)));
    	
    	
        return new ModelAndView("pages/shopping_cart/shopping_cart", new HashMap<String, Serializable>() {{
            put("title", "Courses");
            put("description", "Courses CodelyTV - Backoffice");
            put("identificador", response.id());
            put("session_id", response.sessionId());
            put("amount_total", response.amountTotal());
            put("items_total", response.totalItems());
        }});
    }
}
