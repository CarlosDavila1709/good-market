package store.market.administration.product.application.update_price;

import store.market.administration.product.domain.ProductId;
import store.market.administration.product.domain.ProductPrice;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.command.CommandHandler;

@Service
public final class UpdateProductPriceCommandHandler implements CommandHandler<UpdateProductPriceCommand>{

	private ProductPriceUpdater updater;
	
	public UpdateProductPriceCommandHandler(ProductPriceUpdater updater) {
		this.updater = updater;
	}

	@Override
	public void handle(UpdateProductPriceCommand command) {
		ProductId id = new ProductId(command.id());
		ProductPrice newPrice = new ProductPrice(command.price());
		updater.update(id, newPrice);
	}
}
