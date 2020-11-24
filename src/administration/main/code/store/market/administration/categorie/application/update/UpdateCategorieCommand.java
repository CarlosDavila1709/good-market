package store.market.administration.categorie.application.update;

import store.market.shared.domain.bus.command.Command;

public class UpdateCategorieCommand  implements Command{

	private String id;
	
	private String name;
	
	public UpdateCategorieCommand(String id,String name ) {
		this.id = id;
		this.name = name;
	}
	public String id() {
		return id;
	}
	public String name() {
		return name;
	}

}
