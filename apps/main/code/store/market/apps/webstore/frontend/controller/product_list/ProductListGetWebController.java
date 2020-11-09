package store.market.apps.webstore.frontend.controller.product_list;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import store.market.administration.shopping_cart.application.ShoppingCartResponse;
import store.market.administration.shopping_cart.application.search_by_session.SearchShoppingCartBySessionQuery;
import store.market.apps.webstore.frontend.controller.abstract_controller.AbstractSessionesController;
import store.market.shared.domain.bus.query.QueryBus;
import store.market.shared.domain.bus.query.QueryHandlerExecutionError;

@Controller
public final class ProductListGetWebController extends AbstractSessionesController{

	private static final long serialVersionUID = -1521424940035310359L;
	
	private final QueryBus queryBus;
	
	public ProductListGetWebController(QueryBus queryBus) {

		this.queryBus = queryBus;
	}
	
    @SuppressWarnings("serial")
	@GetMapping("/products-list")
    public ModelAndView index(HttpSession session,
            @ModelAttribute("inputs") HashMap<String, Serializable> inputs,
            @ModelAttribute("errors") HashMap<String, List<String>> errors
    		) throws QueryHandlerExecutionError {
  
    	ShoppingCartResponse response = queryBus.ask(new SearchShoppingCartBySessionQuery(sessionId(session)));
    	
    	if(response == null) {
    		inicializacionSessionCarrito (session);
    	}else {
        	actualizarSessionCarrito(session,response.amountTotal(),response.totalItems() );
    	}

        return new ModelAndView("pages/product_list/product_list",new HashMap<String, Serializable>() {{
            put("title", "Tiendas");
            put("description", "Courses CodelyTV - Backoffice");
            put("inputs", inputs);
            put("errors", errors);
            put("generated_uuid", UUID.randomUUID().toString());
        }});
    }
}
