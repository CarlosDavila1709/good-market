package store.market.administration.shopping_cart_item.application.add_product;

import store.market.administration.shopping_cart_item.domain.CartItemProductId;
import store.market.administration.shopping_cart_item.domain.CartItemProductName;
import store.market.administration.shopping_cart_item.domain.CartItemProductPrice;
import store.market.administration.shopping_cart_item.domain.CartItemQuantity;
import store.market.administration.shopping_cart_item.domain.ShoppingCartSessionId;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.command.CommandHandler;

@Service
public class AddItemCommandHandler implements CommandHandler<AddItemCommand>  {

    private final AddProductCart add;

    public AddItemCommandHandler(AddProductCart add) {
        this.add = add;
    }

    @Override
    public void handle(AddItemCommand command) {
    	
    	ShoppingCartSessionId shoppingCartId = new ShoppingCartSessionId(command.sessionId());
        CartItemProductId     productId     = new CartItemProductId(command.productId());
        CartItemProductName productName = new CartItemProductName("pañales");
        CartItemProductPrice price = new CartItemProductPrice(command.price());
        CartItemQuantity quantity = new CartItemQuantity(command.quantity());
        
        add.add(shoppingCartId, productId, price, productName,quantity);
    }
}
