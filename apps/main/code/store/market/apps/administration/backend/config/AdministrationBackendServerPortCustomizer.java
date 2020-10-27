package store.market.apps.administration.backend.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

import store.market.shared.infrastructure.config.Parameter;
import store.market.shared.infrastructure.config.ParameterNotExist;

@Component
public class AdministrationBackendServerPortCustomizer
		implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

	private final Parameter param;

	public AdministrationBackendServerPortCustomizer(Parameter param) {

		this.param = param;
	}

	@Override
	public void customize(ConfigurableWebServerFactory factory) {
		try {
			factory.setPort(param.getInt("ADMIN_BACKEND_SERVER_PORT"));
		} catch (ParameterNotExist parameterNotExist) {
			parameterNotExist.printStackTrace();
		}
	}
}
