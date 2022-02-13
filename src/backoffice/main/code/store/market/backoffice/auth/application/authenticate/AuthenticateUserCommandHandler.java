package store.market.backoffice.auth.application.authenticate;

import store.market.backoffice.auth.domain.AuthUserEmail;
import store.market.backoffice.auth.domain.AuthUserPassword;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.command.CommandHandler;

@Service
public final class AuthenticateUserCommandHandler implements CommandHandler<AuthenticateUserCommand>{

	private final UserAuthenticator authenticator;

    public AuthenticateUserCommandHandler(UserAuthenticator authenticator) {
        this.authenticator = authenticator;
    }

    @Override
    public void handle(AuthenticateUserCommand command) {
        AuthUserEmail username = new AuthUserEmail(command.username());
        AuthUserPassword password = new AuthUserPassword(command.password());

        authenticator.authenticate(username, password);
    }
}
