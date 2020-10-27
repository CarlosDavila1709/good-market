package store.market.administration.categorie.application.create;

import store.market.administration.categorie.domain.BackofficeGroceryId;
import store.market.administration.categorie.domain.Categorie;
import store.market.administration.categorie.domain.CategorieId;
import store.market.administration.categorie.domain.CategorieName;
import store.market.administration.categorie.domain.CategorieRepository;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.event.EventBus;

@Service
public final class CategorieCreator {

	private final CategorieRepository repository;
	
	private final EventBus eventBus;
	
	public CategorieCreator(CategorieRepository repository,  EventBus eventBus) {
	
		this.repository = repository;
		this.eventBus = eventBus;
	}
	public void create(CategorieId id, CategorieName name,BackofficeGroceryId groceryId) {
	
		Categorie categorie = Categorie.create(id, name,groceryId);
		
		repository.save(categorie);
		
		eventBus.publish(categorie.pullDomainEvents());
	}
}
