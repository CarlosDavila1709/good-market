package store.market.apps.administration.frontend.controller.product;

import java.io.Serializable;
import java.util.HashMap;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import store.market.administration.product.application.create.CreateProductCommand;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.command.CommandHandlerExecutionError;
import store.market.shared.infrastructure.validation.ValidationResponse;
import store.market.shared.infrastructure.validation.Validator;

@Controller
public final class ProductPostWebController {

    private final CommandBus bus;
    
    public ProductPostWebController(CommandBus bus) {
        this.bus = bus;
    }
    private final HashMap<String, String> rules = new HashMap<String, String>() {

		private static final long serialVersionUID = -2838281027538053917L;

	{
        put("id", "required|not_empty|uuid");
        put("name", "required|not_empty|string");
        put("categorieID", "required|not_empty|string");
        put("measureID", "required|not_empty|string");
        put("price", "required|not_empty|string");
    }};
    
    @PostMapping(value = "/products", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public RedirectView index(@RequestParam HashMap<String, Serializable> request, RedirectAttributes attributes) throws Exception {
       
    	ValidationResponse validationResponse = Validator.validate(request, rules);

        return validationResponse.hasErrors()
            ? redirectWithErrors(validationResponse, request, attributes)
            : createCategorie(request);
    }
    private RedirectView redirectWithErrors(
            ValidationResponse validationResponse,
            HashMap<String, Serializable> request,
            RedirectAttributes attributes
        ) {
            attributes.addFlashAttribute("errors", validationResponse.errors());
            attributes.addFlashAttribute("inputs", request);

            return new RedirectView("/products");
   }
    
    private RedirectView createCategorie(HashMap<String, Serializable> request) throws CommandHandlerExecutionError {
        
    	bus.dispatch(new CreateProductCommand(
            request.get("id").toString(),
            request.get("categorieID").toString(),
            request.get("measureID").toString(),
            request.get("name").toString(),
            Double.valueOf(request.get("price").toString())
        ));

        return new RedirectView("/products");
    }
}
