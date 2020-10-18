package store.market.backoffice.grocery.application.create;

import store.market.shared.domain.bus.command.Command;

public final class CreateGroceryCommand implements Command{

	private String id;
	
	private String nameCommercial;
	
	private String address;
	
	private String active;
	
	public CreateGroceryCommand( String id, String nameCommercial, String address, String active) {
		
		this.id = id;
		this.nameCommercial = nameCommercial;
		this.address = address;
		this.active = active;
	}
	
	public String id() {
		return id;
	}
	
	public String nameCommercial() {
		return nameCommercial;
		
	}
	
	public String address() {
		return address;
	}
	
	public String active() {
		return active;
	}
	
}
