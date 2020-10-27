package store.market.apps.administration.frontend.controller.unit_measure;

import java.io.Serializable;
import java.util.HashMap;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import store.market.administration.unit_measure.application.create.CreateUnitMeasureCommand;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.command.CommandHandlerExecutionError;
import store.market.shared.infrastructure.validation.ValidationResponse;
import store.market.shared.infrastructure.validation.Validator;

@Controller
public class UnitMeasurePostWebController {

    private final CommandBus bus;
    
    public UnitMeasurePostWebController(CommandBus bus) {
        this.bus = bus;
    }
    private final HashMap<String, String> rules = new HashMap<String, String>() {

		private static final long serialVersionUID = -2838281027538053917L;

	{
        put("id", "required|not_empty|uuid");
        put("name", "required|not_empty|string");
        put("prefix", "required|not_empty|string");

    }};
    
    @PostMapping(value = "/unitmeasures", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public RedirectView index(@RequestParam HashMap<String, Serializable> request, RedirectAttributes attributes) throws Exception {
       
    	ValidationResponse validationResponse = Validator.validate(request, rules);

        return validationResponse.hasErrors()
            ? redirectWithErrors(validationResponse, request, attributes)
            : createUnitMeasure(request);
    }
    private RedirectView redirectWithErrors(
            ValidationResponse validationResponse,
            HashMap<String, Serializable> request,
            RedirectAttributes attributes
        ) {
            attributes.addFlashAttribute("errors", validationResponse.errors());
            attributes.addFlashAttribute("inputs", request);

            return new RedirectView("/unitmeasures");
   }
    
    private RedirectView createUnitMeasure(HashMap<String, Serializable> request) throws CommandHandlerExecutionError {
        
    	bus.dispatch(new CreateUnitMeasureCommand(
            request.get("id").toString(),
            request.get("name").toString(),
            request.get("prefix").toString()
        ));

        return new RedirectView("/unitmeasures");
    }
}
