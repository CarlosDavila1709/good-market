package store.market.apps.backoffice.frontend;


import java.util.HashMap;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import store.market.shared.domain.Service;

@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class,SecurityAutoConfiguration.class})
@ComponentScan(
    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
    value = {"store.market.shared", "store.market.backoffice", "store.market.administration", "store.market.apps.backoffice.frontend"}
)
public class BackofficeFrontendApplication {

	
	public static HashMap<String, Class<?>> commands() {
        return new HashMap<String, Class<?>>() {{
        }};
    }
	
	
	
}
