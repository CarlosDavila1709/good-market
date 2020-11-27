package store.market.administration.order.application.create;


import java.time.LocalDateTime;
import java.util.ArrayList;


import store.market.administration.customer.application.CustomerResponse;
import store.market.administration.customer.application.find.FindCustomerQuery;
import store.market.administration.customer.domain.CustomerId;
import store.market.administration.customer.domain.CustomerNotExist;

import store.market.administration.order.domain.Order;
import store.market.administration.order.domain.OrderDateCreation;
import store.market.administration.order.domain.OrderId;
import store.market.administration.order.domain.OrderRepository;
import store.market.administration.order.domain.OrderStatus;
import store.market.administration.order.domain.StatusType;
import store.market.administration.order_status.application.StatusOrderResponse;
import store.market.administration.order_status.application.find.FindOrderStatusQuery;
import store.market.administration.product_catalog.domain.ProductCatalogId;
import store.market.administration.shopping_cart.application.ShoppingCartResponse;
import store.market.administration.shopping_cart.application.search_by_session_active.SearchShoppingCartBySessionQuery;
import store.market.administration.shopping_cart.domain.SessionNotExistNotInitialized;

import store.market.shared.domain.Service;
import store.market.shared.domain.Utils;
import store.market.shared.domain.bus.event.EventBus;
import store.market.shared.domain.bus.query.QueryBus;

@Service
public final class OrderCreator {


	private final OrderRepository repository;
    private final QueryBus queryBus;
    private final EventBus eventBus;
    
	public OrderCreator(OrderRepository repository,QueryBus queryBus,EventBus eventBus) {
		
		this.repository = repository;
		this.queryBus 	= queryBus;
		this.eventBus 	= eventBus;
	}
	
	public void create(OrderId id, String customerId,String sessionId ) {
		
		CustomerResponse customer = queryBus.ask(new FindCustomerQuery(customerId));
		if(customer == null) {
			throw new CustomerNotExist(new CustomerId(customerId));
		}
		
		ShoppingCartResponse shopping = queryBus.ask(new SearchShoppingCartBySessionQuery(sessionId));
		if(shopping == null) {
			throw new SessionNotExistNotInitialized();
		}

		StatusOrderResponse status = queryBus.ask(new FindOrderStatusQuery(StatusType.SENT.codigo()));
		
		Order order = Order.create(id,
				new OrderStatus(status.codigo()), 
				customer,
				shopping,
				new ArrayList<>(),
				new OrderDateCreation(Utils.dateToString(LocalDateTime.now())),
				status.description(),
				customer.customerFirstName() + " " +customer.customerLastName());
		
		shopping.existingProducts().forEach(
				productId -> order.incrementProduct(new ProductCatalogId(productId))
				);
		
		repository.save(order);
		
		eventBus.publish(order.pullDomainEvents());
	}
}
