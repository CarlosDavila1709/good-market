package store.market.administration.categorie.application.update;

import store.market.administration.categorie.domain.CategorieId;
import store.market.administration.categorie.domain.CategorieName;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.command.CommandHandler;

@Service
public final class UpdateCategorieCommandHandler implements CommandHandler<UpdateCategorieCommand>{

	private CategorieUpdater updater;
	
	public UpdateCategorieCommandHandler(CategorieUpdater updater) {
		
		this.updater = updater;
	}
	
	@Override
	public void handle(UpdateCategorieCommand command) {
			
		CategorieId id = new CategorieId(command.id());
	    CategorieName name = new CategorieName(command.name());
	    
	    updater.update(id, name);
	}

}
