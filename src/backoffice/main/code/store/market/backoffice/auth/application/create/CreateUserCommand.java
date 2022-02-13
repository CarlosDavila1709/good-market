package store.market.backoffice.auth.application.create;

import store.market.shared.domain.bus.command.Command;

public class CreateUserCommand implements Command{

	private final String uid;
    private final String email;
    private final String password;
    private final String uidGrocery;
    
    public CreateUserCommand(String uid, String email, String password, String uidGrocery) {
    	this.uid		= uid;
    	this.email 		= email;
    	this.password 	= password;
    	this.uidGrocery = uidGrocery;
    }
    
    public String uid() {
    	return uid;
    }
    public String email() {
        return email;
    }
    public String password() {
        return password;
    }
    public String uidGrocery() {
        return uidGrocery;
    }
}
