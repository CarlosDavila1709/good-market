package store.market.administration.shopping_cart.application.create;

import store.market.administration.shopping_cart.domain.ShoppingCartAmountTotal;
import store.market.administration.shopping_cart.domain.ShoppingCartId;
import store.market.administration.shopping_cart.domain.ShoppingCartSessionId;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.command.CommandHandler;

@Service
public class CreateShoppingCartCommandHandler implements CommandHandler<CreateShoppingCartCommand>{

	private final ShoppingCartCreator creator;
	
	public CreateShoppingCartCommandHandler(ShoppingCartCreator creator) {
		
		this.creator = creator;
	}
    @Override
    public void handle(CreateShoppingCartCommand command) {
        
    	ShoppingCartId       	 id       		= new ShoppingCartId(command.id());
        ShoppingCartSessionId 	 sessionId  	= new ShoppingCartSessionId(command.sessionId());
        ShoppingCartAmountTotal  amounttotal 	= new ShoppingCartAmountTotal(command.amountTotal());

        creator.create(id,sessionId,amounttotal);
    }
}
