package store.market.administration.order.domain;

import java.util.List;
import java.util.Optional;

import store.market.shared.domain.criteria.Criteria;

public interface OrderRepository {

	void save(Order order);

    Optional<Order> search(OrderId id);

    List<Order> matching(Criteria criteria);

}
