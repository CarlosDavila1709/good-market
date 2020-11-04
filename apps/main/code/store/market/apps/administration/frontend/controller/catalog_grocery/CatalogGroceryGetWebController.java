package store.market.apps.administration.frontend.controller.catalog_grocery;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import store.market.shared.domain.bus.query.QueryHandlerExecutionError;

@Controller
public final class CatalogGroceryGetWebController {

    @GetMapping("/catalog-grocery")
    public ModelAndView index(
            @ModelAttribute("inputs") HashMap<String, Serializable> inputs,
            @ModelAttribute("errors") HashMap<String, List<String>> errors
    		) throws QueryHandlerExecutionError {
       
        return new ModelAndView("pages/catalog_grocery/categorie/catalog",new HashMap<String, Serializable>() {{
            put("title", "Tiendas");
            put("description", "Courses CodelyTV - Backoffice");
            put("inputs", inputs);
            put("errors", errors);
            put("generated_uuid", UUID.randomUUID().toString());
        }});
    }
}
