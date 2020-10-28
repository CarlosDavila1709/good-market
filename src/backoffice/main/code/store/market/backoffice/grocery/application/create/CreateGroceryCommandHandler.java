package store.market.backoffice.grocery.application.create;

import store.market.backoffice.grocery.domain.GroceryActive;
import store.market.backoffice.grocery.domain.GroceryAddress;
import store.market.backoffice.grocery.domain.GroceryId;
import store.market.backoffice.grocery.domain.GroceryNameCommercial;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateGroceryCommandHandler implements CommandHandler<CreateGroceryCommand>{

	private final GroceryCreator creator;
	
	
	public CreateGroceryCommandHandler(GroceryCreator creator) {
	
		this.creator = creator;
	}
	
    @Override
    public void handle(CreateGroceryCommand command) {
    	
    	GroceryId id = new GroceryId(command.id());
    	GroceryNameCommercial nameCommercial = new GroceryNameCommercial(command.nameCommercial());
    	GroceryAddress address = new GroceryAddress(command.address());
    	GroceryActive active = new GroceryActive(command.active());
    	
    	creator.create(id, nameCommercial, address, active);
    }
}
