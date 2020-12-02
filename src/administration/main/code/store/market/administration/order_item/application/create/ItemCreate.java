package store.market.administration.order_item.application.create;

import store.market.administration.order.domain.OrderId;
import store.market.administration.order_item.domain.Item;
import store.market.administration.order_item.domain.ItemAmountTotal;
import store.market.administration.order_item.domain.ItemId;
import store.market.administration.order_item.domain.ItemProductName;
import store.market.administration.order_item.domain.ItemProductPrice;
import store.market.administration.order_item.domain.ItemQuantity;
import store.market.administration.order_item.domain.ItemRepository;
import store.market.administration.product_catalog.domain.ProductCatalogId;
import store.market.administration.shopping_cart.domain.ShoppingCartId;
import store.market.administration.shopping_cart_item.application.CartItemResponse;
import store.market.administration.shopping_cart_item.application.CartItemsResponse;
import store.market.administration.shopping_cart_item.application.search_by_cart.SearchCartItemByCartQuery;
import store.market.shared.domain.Service;
import store.market.shared.domain.UuidGenerator;
import store.market.shared.domain.bus.query.QueryBus;

@Service
public final class ItemCreate {

	private final ItemRepository repository;
	private UuidGenerator  uuidGenerator;
	private final QueryBus queryBus;
	
	public ItemCreate(ItemRepository repository,QueryBus queryBus,UuidGenerator uuidGenerator) {
		
		this.repository    = repository;
		this.queryBus 	   = queryBus;
		this.uuidGenerator = uuidGenerator;
	}
	
	public void create(OrderId orderId,ShoppingCartId id) {
		
		CartItemsResponse cartItemsResponse = queryBus.ask(new SearchCartItemByCartQuery(id.value()));

		cartItemsResponse.items().forEach(itemCart -> save(orderId,itemCart));
		
	}
	
	private void save(OrderId orderId,CartItemResponse cartItemResponse) {
		Item item = Item.create( 
				new ItemId(uuidGenerator.generate()), 
				orderId, 
				new ProductCatalogId(cartItemResponse.productId()), 
				new ItemProductName(cartItemResponse.productName()), 
				new ItemProductPrice(cartItemResponse.productPrice()), 
				new ItemAmountTotal(cartItemResponse.amountTotal()), 
				new ItemQuantity(cartItemResponse.quantity()),
				cartItemResponse.categorieName(),
				cartItemResponse.unitMeasureName());
		repository.save(item);
	}
}
