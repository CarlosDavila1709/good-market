package store.market.administration.product.application.delete;

import store.market.administration.product.domain.ProductId;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.command.CommandHandler;

@Service
public class DeleteProductCommandHandler implements CommandHandler<DeleteProductCommand>{

	private final ProductDeleter deleter;
	
	public DeleteProductCommandHandler(ProductDeleter deleter) {
	
		this.deleter = deleter;
	}
	
	@Override
	public void handle(DeleteProductCommand command) {
		ProductId id = new ProductId(command.id());
		deleter.delete(id);
	}
}
