package store.market.administration.shopping_cart.application.update_quantity_product;

import store.market.administration.product_catalog.domain.ProductCatalogId;
import store.market.administration.shopping_cart.domain.ShoppingCart;
import store.market.administration.shopping_cart.domain.ShoppingCartAmountTotal;
import store.market.administration.shopping_cart.domain.ShoppingCartId;
import store.market.administration.shopping_cart.domain.ShoppingCartNotExist;
import store.market.administration.shopping_cart.domain.ShoppingCartQuantity;
import store.market.administration.shopping_cart.domain.ShoppingCartRepository;
import store.market.administration.shopping_cart_item.application.CartItemsResponse;
import store.market.administration.shopping_cart_item.application.search_by_cart.SearchCartItemByCartQuery;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.query.QueryBus;

@Service
public class UpdateAmountAndTotalsUpdater {

	private final QueryBus 		   queryBus;
	private ShoppingCartRepository repository;
	
	public UpdateAmountAndTotalsUpdater(ShoppingCartRepository repository,QueryBus queryBus) {
		
		this.repository = repository;
		this.queryBus = queryBus;
	}
	
	public void update(ShoppingCartId id,ProductCatalogId productId, ShoppingCartQuantity quantity) {
		
		ShoppingCart cart = repository.search(id).orElseThrow(()->{ throw new ShoppingCartNotExist(id);});
		
		CartItemsResponse items = queryBus.ask(new SearchCartItemByCartQuery(id.value()));
		
		cart.inizializeAmount();
		cart.inizializeTotalItems();
		items.items().forEach(item -> {
			cart.increaseAmount(new ShoppingCartAmountTotal(item.amountTotal()));
			cart.increaseQuantityItems(new ShoppingCartQuantity(item.quantity()));
		}); 
		
		repository.save(cart);
		
	}
}
