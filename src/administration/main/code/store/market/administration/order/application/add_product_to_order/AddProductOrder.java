package store.market.administration.order.application.add_product_to_order;

import store.market.administration.order.domain.Order;
import store.market.administration.order.domain.OrderAmountTotal;
import store.market.administration.order.domain.OrderId;
import store.market.administration.order.domain.OrderNotExist;
import store.market.administration.order.domain.OrderRepository;
import store.market.administration.product_catalog.application.ProductCatalogResponse;
import store.market.administration.product_catalog.application.find.FindProductCatalogQuery;
import store.market.administration.product_catalog.domain.ProductCatalogId;
import store.market.shared.domain.Service;
import store.market.shared.domain.bus.event.EventBus;
import store.market.shared.domain.bus.query.QueryBus;

@Service
public final class AddProductOrder {

	private final OrderRepository  	repository;
	private final QueryBus   		queryBus;
    private final EventBus   		eventBus;
    
    public AddProductOrder(OrderRepository repository,QueryBus queryBus, EventBus eventBus) {
		this.repository = repository;
		this.queryBus = queryBus;
		this.eventBus = eventBus;
    }
    
    public void add(OrderId orderId, ProductCatalogId productCatalogId,Integer quantity) {
    	
    	ProductCatalogResponse  product = queryBus.ask(new FindProductCatalogQuery(productCatalogId.value()));
    	Order order = repository.search(orderId).orElseThrow(() -> new OrderNotExist(orderId));
    	
    	Double amountTotal = quantity * product.price();
    	order.addProduct(productCatalogId,quantity);
    	order.increaseAmount(new OrderAmountTotal(amountTotal));
    	repository.save(order);
    	eventBus.publish(order.pullDomainEvents());
    }
}
