package store.market.apps.administration.frontend.controller.shopping_cart;

import org.springframework.http.MediaType;
import java.io.Serializable;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import store.market.administration.shopping_cart.application.add_product_to_card.AddProductShoppingCartCommand;

import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.command.CommandHandlerExecutionError;
import store.market.shared.infrastructure.validation.ValidationResponse;
import store.market.shared.infrastructure.validation.Validator;

@Controller
public final class ShoppingCartPostWebController {

    private final CommandBus              bus;
    
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
        
    	String sessionId = (String) session.getAttribute("session-id");
    	System.out.println("session: "+sessionId);
    	
    	ValidationResponse validationResponse = Validator.validate(request, rules);

        return validationResponse.hasErrors()
            ? redirectWithErrors(validationResponse, request, attributes)
            : addProductCart(request,sessionId);
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
   private String getSessionId() {  
	 
	   System.out.println("session id: " + RequestContextHolder.currentRequestAttributes().getSessionId());
	   return RequestContextHolder.currentRequestAttributes().getSessionId();

	}
}
