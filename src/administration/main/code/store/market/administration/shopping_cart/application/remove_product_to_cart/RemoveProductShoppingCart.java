package store.market.administration.shopping_cart.application.remove_product_to_cart;

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
public final class RemoveProductShoppingCart {

	private ShoppingCartRepository repository;
	private final QueryBus queryBus;
    
	public RemoveProductShoppingCart(ShoppingCartRepository repository,QueryBus queryBus) {
		
		this.repository = repository;
		this.queryBus = queryBus;
	}
	
	public void remove(ShoppingCartId shoppingCartId,ProductCatalogId productId,String itemId ) {
		
		ShoppingCart cart = repository.search(shoppingCartId).orElseThrow(()-> new ShoppingCartNotExist(shoppingCartId));
		
		CartItemsResponse items = queryBus.ask(new SearchCartItemByCartQuery(shoppingCartId.value()));

		cart.removeProduct(productId);
		
		cart.inizializeAmount();
		cart.inizializeTotalItems();
		items.items().forEach(item -> {
			cart.increaseAmount(new ShoppingCartAmountTotal(item.amountTotal()));
			cart.increaseQuantityItems(new ShoppingCartQuantity(item.quantity()));
		}); 
		
		//cart.subtractAmount(product.price(),productId);

		repository.save(cart);

	}
}
