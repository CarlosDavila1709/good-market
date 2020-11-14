package store.market.apps.webstore.frontend.controller.home;

import java.io.Serializable;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.ModelAndView;

import store.market.administration.shopping_cart.application.ShoppingCartResponse;
import store.market.administration.shopping_cart.application.search_by_session_active.SearchShoppingCartBySessionQuery;
import store.market.apps.webstore.frontend.controller.abstract_controller.AbstractSessionesController;
import store.market.shared.domain.bus.query.QueryBus;

@Controller
public final class HomeGetWebController extends AbstractSessionesController{

	private static final long serialVersionUID = -3659025788135439397L;
	private final QueryBus queryBus;
	
	public HomeGetWebController(QueryBus queryBus) {

		this.queryBus = queryBus;
		
	}
	
    @SuppressWarnings("serial")
	@GetMapping("/")
    public ModelAndView index(HttpSession session) {

    	ShoppingCartResponse response = queryBus.ask(new SearchShoppingCartBySessionQuery(sessionId(session)));
    	
    	if(response == null) {
    		inicializacionSessionCarrito (session);
    	}else {
        	actualizarSessionCarrito(session,response.amountTotal(),response.totalItems() );
    	}

        return new ModelAndView("pages/home", new HashMap<String, Serializable>() {{
            put("title", "Welcome");
            put("description", "CodelyTV - Backoffice" );
        }});
    }

}
