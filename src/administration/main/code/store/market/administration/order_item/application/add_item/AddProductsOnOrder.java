package store.market.administration.order_item.application.add_item;

import store.market.administration.order.domain.OrderId;
import store.market.administration.order_item.domain.Item;
import store.market.administration.order_item.domain.ItemAmountTotal;
import store.market.administration.order_item.domain.ItemId;
import store.market.administration.order_item.domain.ItemProductName;
import store.market.administration.order_item.domain.ItemProductPrice;
import store.market.administration.order_item.domain.ItemQuantity;
import store.market.administration.order_item.domain.ItemRepository;
import store.market.administration.product_catalog.application.ProductCatalogResponse;
import store.market.administration.product_catalog.application.find.FindProductCatalogQuery;
import store.market.administration.product_catalog.domain.ProductCatalogId;
import store.market.shared.domain.Service;
import store.market.shared.domain.UuidGenerator;
import store.market.shared.domain.bus.query.QueryBus;

@Service
public final class AddProductsOnOrder {
	
	private final UuidGenerator  uuidGenerator;
	private final QueryBus   	 queryBus;
	private final ItemRepository repository;
	
	public AddProductsOnOrder(ItemRepository repository,UuidGenerator uuidGenerator,QueryBus  queryBus) {
		
		this.repository 	= repository;
		this.uuidGenerator  = uuidGenerator;
		this.queryBus       = queryBus;
	}
	
	public void add(OrderId orderId, ItemQuantity quantity, ProductCatalogId productCatalogId) {
    	
		ProductCatalogResponse response = queryBus.ask(new FindProductCatalogQuery(productCatalogId.value()));
    	
		Item item = Item.create(
				new ItemId(uuidGenerator.generate()), 
				orderId, 
				productCatalogId, 
				new ItemProductName(response.name()), 
				new ItemProductPrice(response.price()), 
				new ItemAmountTotal(response.price()*quantity.value()), 
				quantity,
				response.categorieName(),
				response.unitMeasureName());
		
		repository.save(item);
	}
}
