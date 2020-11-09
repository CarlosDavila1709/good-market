package store.market.apps.webstore.frontend.controller.shopping_cart;

import java.io.Serializable;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import store.market.administration.shopping_cart.application.add_product_to_card.AddProductShoppingCartCommand;
import store.market.apps.webstore.frontend.controller.abstract_controller.AbstractSessionesController;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.command.CommandHandlerExecutionError;
import store.market.shared.infrastructure.validation.ValidationResponse;
import store.market.shared.infrastructure.validation.Validator;

@Controller
public class ShoppingCartPostWebController extends AbstractSessionesController{

	private static final long serialVersionUID = -1825845705509552538L;

	private final CommandBus              bus;
    
    @SuppressWarnings("serial")
	private final HashMap<String, String> rules = new HashMap<String, String>() {{
        put("productId", "required|not_empty|string");
        put("price", "required|not_empty|string");
        put("quantity", "required|not_empty|string");
    }};
    
    public ShoppingCartPostWebController(CommandBus bus) {
        
    	this.bus = bus;
    }
    
    @PostMapping(value = "/add-cart", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public RedirectView index(HttpSession session,
        @RequestParam HashMap<String, Serializable> request,
        RedirectAttributes attributes
    ) throws Exception {
            	
    	ValidationResponse validationResponse = Validator.validate(request, rules);

        return validationResponse.hasErrors()
            ? redirectWithErrors(validationResponse, request, attributes)
            : addProductCart(request,sessionId(session));
    }

   private RedirectView addProductCart(HashMap<String, Serializable> request,String sessionId) throws CommandHandlerExecutionError {

	  
        bus.dispatch(new AddProductShoppingCartCommand(
        		sessionId ,
            	"78bd479b-5a06-48b6-8b9a-f8b5d4d889f8",
                request.get("productId").toString(),
                Integer.valueOf(request.get("quantity").toString())
            ));
        
        return new RedirectView("/products-list");
    }
   
   @SuppressWarnings("unused")
	private RedirectView redirectWithErrors(
           ValidationResponse validationResponse,
           HashMap<String, Serializable> request,
           RedirectAttributes attributes
       ) {
           attributes.addFlashAttribute("errors", validationResponse.errors());
           attributes.addFlashAttribute("inputs", request);

           return new RedirectView("/products-list");
  }
}
