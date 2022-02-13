package store.market.apps.backoffice.backend.controller.user;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import store.market.backoffice.auth.application.create.CreateUserCommand;
import store.market.backoffice.auth.domain.AuthUserAlreadyExists;
import store.market.backoffice.auth.domain.PasswordIncorrect;
import store.market.shared.domain.DomainError;
import store.market.shared.domain.bus.command.CommandBus;
import store.market.shared.domain.bus.command.CommandHandlerExecutionError;
import store.market.shared.domain.bus.query.QueryBus;
import store.market.shared.infrastructure.spring.ApiController;

@RestController
public final class UserPutController extends ApiController{

	public UserPutController(QueryBus queryBus, CommandBus commandBus) {
		
		super(queryBus, commandBus);
		
	}
	
    @PutMapping(value = "/users/{id}")
    public ResponseEntity<String> index(@PathVariable String id,@RequestBody Request request) throws CommandHandlerExecutionError {
        
    	dispatch(new CreateUserCommand(id, request.email(), request.password(),request.grocery().uid()));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
	
	@Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
    	
		return new HashMap<Class<? extends DomainError>, HttpStatus>() {{
            put(AuthUserAlreadyExists.class, HttpStatus.CONFLICT);
            put(PasswordIncorrect.class, HttpStatus.CONFLICT);
        }};
	 }
}

final class Request {

    private String email;
    private String password;
    private RequestGrocery grocery;
    
    public void setEmail(String email) {
    	this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGrocery(RequestGrocery grocery) {
    	this.grocery = grocery;
    }
    

    String email() {
        return email;
    }

    String password() {
        return password;
    }
    RequestGrocery grocery() {
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
