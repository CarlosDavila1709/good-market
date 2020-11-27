package store.market.administration.product.application.delete;

import store.market.shared.domain.bus.command.Command;

public class DeleteProductCommand  implements Command{
	private final String id;
	
	public DeleteProductCommand(String id) {
		this.id = id;
	}
	public String id() {
        return id;
    }
}
