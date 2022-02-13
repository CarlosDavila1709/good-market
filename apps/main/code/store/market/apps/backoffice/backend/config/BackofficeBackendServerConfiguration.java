package store.market.apps.backoffice.backend.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import store.market.apps.backoffice.backend.middleware.BasicHttpAuthMiddleware;
import store.market.apps.backoffice.backend.middleware.BasicHttpTokenMiddleware;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.infrastructure.spring.ApiExceptionMiddleware;

@Configuration
public class BackofficeBackendServerConfiguration {

	private final RequestMappingHandlerMapping mapping;
	private final CommandBus bus;

    public BackofficeBackendServerConfiguration(RequestMappingHandlerMapping mapping,CommandBus bus) {
        this.mapping = mapping;
        this.bus     = bus;
    }

    @Bean
    public FilterRegistrationBean<ApiExceptionMiddleware> basicHttpAuthMiddleware() {
        FilterRegistrationBean<ApiExceptionMiddleware> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new ApiExceptionMiddleware(mapping));

        return registrationBean;
    }
    @Bean
    public FilterRegistrationBean<BasicHttpTokenMiddleware> basicHttpAuthMiddleware2() {
        FilterRegistrationBean<BasicHttpTokenMiddleware> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new BasicHttpTokenMiddleware(bus));
        registrationBean.addUrlPatterns("/health-check");

        return registrationBean;
    }
}
