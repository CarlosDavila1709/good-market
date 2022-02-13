package store.market.apps.backoffice.backend.controller.login;

import java.io.Serializable;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import store.market.backoffice.auth.application.TokenResponse;
import store.market.backoffice.auth.application.login.LoginQuery;
import store.market.backoffice.auth.domain.AuthUserNotExist;
import store.market.shared.domain.DomainError;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.query.QueryBus;
import store.market.shared.domain.bus.query.QueryHandlerExecutionError;
import store.market.shared.infrastructure.spring.ApiController;

@RestController
public final class LoginGetController extends ApiController {

    public LoginGetController(QueryBus queryBus, CommandBus commandBus) {
    	
    	super(queryBus, commandBus);
    	
    }
    
    @GetMapping("/login")
    public ResponseEntity<HashMap<String, Serializable>> index(@RequestBody Request request) throws QueryHandlerExecutionError {
        
    	TokenResponse response = ask(new LoginQuery(request.email(),
    											   request.password()));

        return ResponseEntity.ok().body(new HashMap<String, Serializable>() {{
            put("token", response.code());
        }});
    }
    
    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        
    	return new HashMap<Class<? extends DomainError>, HttpStatus>() {{
            put(AuthUserNotExist.class, HttpStatus.NOT_FOUND);
        }};
    }
}


final class Request {
    private String email;
    private String password;

    public void setEmail(String email) {

    	this.email		= email;

    }

    public void setPassword(String password) {
        this.password = password;
    }

    String email() {
        return email;
    }

    String password() {
        return password;
    }
}