package store.market.administration.categorie.application.create;

import store.market.shared.domain.bus.command.Command;

public final class CreateCategorieCommand implements Command{

	private final String id;
	
	private final String groceryId;
	
	private final String name;
	
	public CreateCategorieCommand(String id, String groceryId, String name) {
		
		this.id = id;
		this.groceryId = groceryId;
		this.name = name;
	}
	
	public String id() {
		return id;
	}
	public String groceryId() {
		return groceryId;
	}
	public String name() {
		return name;
	}
}
