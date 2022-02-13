package store.market.backoffice.auth.application.authenticate_by_token;

import store.market.shared.domain.bus.command.Command;

public final class AuthenticateTokenCommand implements Command {

	private String token;
	
	public AuthenticateTokenCommand(String token) {
		this.token = token;
	}
	
	public String token() {
		return token;
	}
}
