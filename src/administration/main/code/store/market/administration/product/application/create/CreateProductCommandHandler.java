package store.market.administration.product.application.create;

import store.market.administration.grocery.domain.BackofficeGroceryId;
import store.market.administration.product.domain.ProductCategorieId;
import store.market.administration.product.domain.ProductId;
import store.market.administration.product.domain.ProductName;
import store.market.administration.product.domain.ProductPrice;
import store.market.administration.product.domain.ProductUnitMeasureId;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.command.CommandHandler;

@Service
public class CreateProductCommandHandler implements CommandHandler<CreateProductCommand> {

    private final ProductCreator creator;

    public CreateProductCommandHandler(ProductCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateProductCommand command) {
        ProductId       	 id       		= new ProductId(command.id());
        ProductCategorieId   categorieId 	= new ProductCategorieId(command.categorieId());
        ProductUnitMeasureId unitMeasureId  = new ProductUnitMeasureId(command.unitMeasureId());
        ProductName 		 name  			= new ProductName(command.name());
        ProductPrice 		 price			= new ProductPrice(command.price());
        BackofficeGroceryId  groceryId      = new BackofficeGroceryId(command.groceryId());
        
        creator.create(id,categorieId,unitMeasureId,groceryId,name,price);
    }
}
