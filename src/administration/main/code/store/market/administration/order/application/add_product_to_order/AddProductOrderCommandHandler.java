package store.market.administration.order.application.add_product_to_order;

import store.market.administration.order.domain.OrderId;
import store.market.administration.product_catalog.domain.ProductCatalogId;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.command.CommandHandler;

@Service
public final class AddProductOrderCommandHandler implements CommandHandler<AddProductOrderCommand>{

	private final AddProductOrder aggregate;
	
	public AddProductOrderCommandHandler(AddProductOrder aggregate) {
		this.aggregate = aggregate;
	}
	
	@Override
	public void handle(AddProductOrderCommand command) {
		
		OrderId orderId 				  = new OrderId(command.orderId());
		ProductCatalogId productCatalogId = new ProductCatalogId(command.productId()); 

		aggregate.add(orderId, productCatalogId, command.quantity());
	}

	
}
