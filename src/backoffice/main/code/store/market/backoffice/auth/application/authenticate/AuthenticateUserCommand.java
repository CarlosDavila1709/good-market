package store.market.backoffice.auth.application.authenticate;

import store.market.shared.domain.bus.command.Command;

public class AuthenticateUserCommand implements Command{

    private final String username;
    private final String password;
    
    public AuthenticateUserCommand(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public String username() {
        return username;
    }

    public String password() {
        return password;
    }
}
