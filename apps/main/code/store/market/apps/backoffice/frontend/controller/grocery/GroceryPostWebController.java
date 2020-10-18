package store.market.apps.backoffice.frontend.controller.grocery;

import java.io.Serializable;
import java.util.HashMap;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import store.market.backoffice.grocery.application.create.CreateGroceryCommand;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.command.CommandHandlerExecutionError;
import store.market.shared.infrastructure.validation.ValidationResponse;
import store.market.shared.infrastructure.validation.Validator;

@Controller
public final class GroceryPostWebController {

    private final CommandBus bus;
    
    private final HashMap<String, String> rules = new HashMap<String, String>() {

		private static final long serialVersionUID = -2838281027538053917L;

	{
        put("id", "required|not_empty|uuid");
        put("nameCommercial", "required|not_empty|string");
        put("address", "required|not_empty|string");
        put("active", "required|not_empty|string");
    }};
    
    public GroceryPostWebController(CommandBus bus) {
        this.bus = bus;
    }
    
    @PostMapping(value = "/grocerys", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public RedirectView index(@RequestParam HashMap<String, Serializable> request, RedirectAttributes attributes) throws Exception {
       
    	ValidationResponse validationResponse = Validator.validate(request, rules);

        return validationResponse.hasErrors()
            ? redirectWithErrors(validationResponse, request, attributes)
            : createGrocery(request);
    }
    
    private RedirectView redirectWithErrors(
            ValidationResponse validationResponse,
            HashMap<String, Serializable> request,
            RedirectAttributes attributes
        ) {
            attributes.addFlashAttribute("errors", validationResponse.errors());
            attributes.addFlashAttribute("inputs", request);

            return new RedirectView("/grocerys");
   }
    

    private RedirectView createGrocery(HashMap<String, Serializable> request) throws CommandHandlerExecutionError {
        bus.dispatch(new CreateGroceryCommand(
            request.get("id").toString(),
            request.get("nameCommercial").toString(),
            request.get("address").toString(),
            request.get("active").toString()
        ));

        return new RedirectView("/grocerys");
    }
}
