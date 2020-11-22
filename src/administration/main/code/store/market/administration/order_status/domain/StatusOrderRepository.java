package store.market.administration.order_status.domain;

import java.util.List;
import java.util.Optional;

import store.market.shared.domain.criteria.Criteria;

public interface StatusOrderRepository {

	void save(OrderStatus course);
	
	 List<OrderStatus> matching(Criteria criteria);
	 
	 List<OrderStatus> searchAll();
	 
	 Optional<OrderStatus> search(String codigo) ;
}
