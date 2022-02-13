package store.market.backoffice.auth.application.create;

import store.market.backoffice.auth.domain.AuthUserEmail;
import store.market.backoffice.auth.domain.AuthUserId;
import store.market.backoffice.auth.domain.AuthUserPassword;
import store.market.backoffice.grocery.domain.GroceryId;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateUserCommandHandler implements CommandHandler<CreateUserCommand>{

	private final UserCreator creator;
	
	public CreateUserCommandHandler(UserCreator creator) {
		
		this.creator = creator;
	}
	
	@Override
	public void handle(CreateUserCommand command) {
		
		AuthUserId id = new AuthUserId(command.uid());
		AuthUserEmail email = new AuthUserEmail(command.email());
		AuthUserPassword password = new AuthUserPassword(command.password());
		GroceryId idGrocery = new GroceryId(command.uidGrocery());

		creator.create(id, email, password, idGrocery);
	}

}
