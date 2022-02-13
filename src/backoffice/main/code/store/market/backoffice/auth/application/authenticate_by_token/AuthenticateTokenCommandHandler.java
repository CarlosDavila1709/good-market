package store.market.backoffice.auth.application.authenticate_by_token;

import store.market.shared.domain.Service;
import store.market.shared.domain.bus.command.CommandHandler;

@Service
public final class AuthenticateTokenCommandHandler implements CommandHandler<AuthenticateTokenCommand>{

	private final TokenAuthenticator authenticator ;
	
	public AuthenticateTokenCommandHandler(TokenAuthenticator authenticator) {
		this.authenticator = authenticator;
	}
    @Override
    public void handle(AuthenticateTokenCommand command) {

        authenticator.authenticate(command.token());
    }
}
