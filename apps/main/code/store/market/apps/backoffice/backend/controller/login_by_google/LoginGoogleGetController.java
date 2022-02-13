package store.market.apps.backoffice.backend.controller.login_by_google;


import java.io.Serializable;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import store.market.backoffice.auth.application.TokenResponse;
import store.market.backoffice.auth.application.login_by_google.LoginGoogleQuery;
import store.market.backoffice.auth.domain.EmailFormatIncorrectException;
import store.market.backoffice.auth.domain.TokenInvalidException;
import store.market.backoffice.grocery.domain.GroceryNotExist;
import store.market.shared.domain.DomainError;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.query.QueryBus;
import store.market.shared.domain.bus.query.QueryHandlerExecutionError;
import store.market.shared.infrastructure.spring.ApiController;

@RestController
public final class LoginGoogleGetController extends ApiController{

    public LoginGoogleGetController(QueryBus queryBus, CommandBus commandBus) {
    	
    	super(queryBus, commandBus);
    	
    }
    
    @GetMapping("/login/google")
    public ResponseEntity<HashMap<String, Serializable>> index(@RequestBody Request request) throws QueryHandlerExecutionError {

		
    	TokenResponse response = ask(new LoginGoogleQuery(request.token(), request.grocery().uid()));

        return ResponseEntity.ok().body(new HashMap<String, Serializable>() {{
            put("token", response.code());
        }});
    }
    
    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        
    	return new HashMap<Class<? extends DomainError>, HttpStatus>() {{
            put(GroceryNotExist.class, HttpStatus.BAD_REQUEST);
            put(EmailFormatIncorrectException.class, HttpStatus.BAD_REQUEST);
    		put(TokenInvalidException.class, HttpStatus.UNAUTHORIZED);

        }};
    }
}

final class Request{
	private String token;
    private RequestGrocery grocery;
    
	public void setToken(String token) {
		this.token = token;
	}
	
	public String token() {
		return token;
	}
	
	public void setGrocery(RequestGrocery grocery) {
		this.grocery = grocery;
	}
	
    public RequestGrocery grocery() {
    	return grocery;
    }
}
final class RequestGrocery {

	private String uid;

	public void setUid(String uid) {
		this.uid = uid;
	}
	
	String uid() {
		return uid;
	}
}