package store.market.administration.categorie.application.delete;

import store.market.shared.domain.bus.command.Command;

public class CategorieCommand implements Command{

	private final String id;
	
	public CategorieCommand(String id) {
		this.id = id;
	}
	public String id() {
        return id;
    }
}
