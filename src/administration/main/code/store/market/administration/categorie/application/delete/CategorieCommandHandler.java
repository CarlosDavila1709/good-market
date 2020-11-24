package store.market.administration.categorie.application.delete;

import store.market.administration.categorie.domain.CategorieId;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.command.CommandHandler;

@Service
public final class CategorieCommandHandler implements CommandHandler<CategorieCommand>{

	private CategorieDeleter deleter;
	
	public CategorieCommandHandler(CategorieDeleter deleter) {
		
		this.deleter = deleter;
	}
	
	@Override
	public void handle(CategorieCommand command) {
	
		CategorieId id = new CategorieId(command.id());
		
		deleter.delete(id);
	}

}
