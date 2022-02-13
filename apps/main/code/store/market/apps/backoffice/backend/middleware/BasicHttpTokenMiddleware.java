package store.market.apps.backoffice.backend.middleware;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.exceptions.JWTVerificationException;

import store.market.backoffice.auth.application.authenticate_by_token.AuthenticateTokenCommand;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.command.CommandHandlerExecutionError;

public final class BasicHttpTokenMiddleware implements Filter{
    private final CommandBus bus;

    public BasicHttpTokenMiddleware(CommandBus bus) {
        this.bus = bus;
    }

    @Override
    public void doFilter(
        ServletRequest request,
        ServletResponse response,
        FilterChain chain
    ) throws IOException, ServletException {
        String authorizationHeader = ((HttpServletRequest) request).getHeader("x-token");

        if (hasIntroducedCredentials(authorizationHeader)) {
            authenticate(authorizationHeader, chain, request, response);
        } else {
            askForCredentials(response);
        }
    }

    private boolean hasIntroducedCredentials(String authorizationHeader) {
        return null != authorizationHeader;
    }

    private void authenticate(
        String authorizationHeader,
        FilterChain chain,
        ServletRequest request,
        ServletResponse response
    ) throws IOException, ServletException {

        try {
            bus.dispatch(new AuthenticateTokenCommand(authorizationHeader));

            request.setAttribute("authentication_username", "ok");

            chain.doFilter(request, response);
        } catch (JWTVerificationException | CommandHandlerExecutionError error) {
            setInvalidCredentials(response);
        }
    }

    private void setInvalidCredentials(ServletResponse response) {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.reset();
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
    }

    private void askForCredentials(ServletResponse response) {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.reset();
        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpServletResponse.setHeader("WWW-Authenticate", "Basic realm=\"CodelyTV\"");
    }
}
