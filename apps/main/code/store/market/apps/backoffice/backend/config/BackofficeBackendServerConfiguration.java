package store.market.apps.backoffice.backend.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import store.market.shared.infrastructure.spring.ApiExceptionMiddleware;

@Configuration
public class BackofficeBackendServerConfiguration {

	private final RequestMappingHandlerMapping mapping;

    public BackofficeBackendServerConfiguration(RequestMappingHandlerMapping mapping) {
        this.mapping = mapping;
    }

    @Bean
    public FilterRegistrationBean<ApiExceptionMiddleware> basicHttpAuthMiddleware() {
        FilterRegistrationBean<ApiExceptionMiddleware> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new ApiExceptionMiddleware(mapping));

        return registrationBean;
    }
    
}
