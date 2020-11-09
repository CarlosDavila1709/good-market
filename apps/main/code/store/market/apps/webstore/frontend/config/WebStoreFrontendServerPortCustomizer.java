package store.market.apps.webstore.frontend.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

import store.market.shared.infrastructure.config.Parameter;
import store.market.shared.infrastructure.config.ParameterNotExist;

@Component
public final class WebStoreFrontendServerPortCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory>{

    private final Parameter param;
    
	public WebStoreFrontendServerPortCustomizer(Parameter param) {
		
		this.param = param;
	}
	
    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        try {
            factory.setPort(param.getInt("WEBSTORE_FRONTEND_SERVER_PORT"));
        } catch (ParameterNotExist parameterNotExist) {
            parameterNotExist.printStackTrace();
        }
    }
}
