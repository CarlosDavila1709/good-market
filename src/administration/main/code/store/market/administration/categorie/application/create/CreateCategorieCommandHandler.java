package store.market.administration.categorie.application.create;

import store.market.administration.categorie.domain.BackofficeGroceryId;
import store.market.administration.categorie.domain.CategorieId;
import store.market.administration.categorie.domain.CategorieName;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateCategorieCommandHandler implements CommandHandler<CreateCategorieCommand> {

	private final CategorieCreator creator;
	
	public CreateCategorieCommandHandler(CategorieCreator creator) {
		
		this.creator = creator;
	}
	
    @Override
    public void handle(CreateCategorieCommand command) {
        
    	CategorieId       id       		= new CategorieId(command.id());
        CategorieName     name     		= new CategorieName(command.name());
        BackofficeGroceryId groceryId 	= new BackofficeGroceryId(command.groceryId());
        
        creator.create(id, name, groceryId);
    }
}
