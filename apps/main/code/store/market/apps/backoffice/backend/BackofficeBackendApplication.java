package store.market.apps.backoffice.backend;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import store.market.shared.domain.Service;

import java.util.HashMap;

@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class,SecurityAutoConfiguration.class})
@ComponentScan(
    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
    value = {"store.market.shared", "store.market.backoffice", "store.market.apps.backoffice.backend"}
)
public class BackofficeBackendApplication {

	public static HashMap<String, Class<?>> commands() {
        return new HashMap<String, Class<?>>() {{
        }};
    }
}
