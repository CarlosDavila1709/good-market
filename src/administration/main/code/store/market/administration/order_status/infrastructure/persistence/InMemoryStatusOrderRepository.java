package store.market.administration.order_status.infrastructure.persistence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import store.market.shared.domain.Service;
import store.market.shared.domain.criteria.Criteria;
import store.market.administration.order.domain.StatusType;
import store.market.administration.order_status.domain.OrderStatus;
import store.market.administration.order_status.domain.StatusOrderRepository;

@Service
public final class InMemoryStatusOrderRepository implements StatusOrderRepository {

	private HashMap<String, OrderStatus> statusTypes = new HashMap<String,OrderStatus>();
	
	public InMemoryStatusOrderRepository() {
		statusTypes.put(StatusType.SENT.codigo(), new OrderStatus(StatusType.SENT.codigo(),"Enviado"));
		statusTypes.put(StatusType.ADMITTED.codigo(), new OrderStatus(StatusType.ADMITTED.codigo(),"Admitido"));
		statusTypes.put(StatusType.DELIVERED.codigo(), new OrderStatus(StatusType.ADMITTED.codigo(),"Entregado"));
		statusTypes.put(StatusType.TRANSIT.codigo(), new OrderStatus(StatusType.ADMITTED.codigo(),"Transito"));
	}
    @Override
	public void save(OrderStatus status) {
		statusTypes.put(status.codigo(), status);
	}

    @Override
	public List<OrderStatus> matching(Criteria criteria) {
		return null;
	}

	@Override
	public List<OrderStatus> searchAll() {

		return Arrays.asList(
				new OrderStatus(StatusType.SENT.codigo(),"Enviado"),
	            new OrderStatus(StatusType.ADMITTED.codigo(),"Admitido"),
	            new OrderStatus(StatusType.DELIVERED.codigo(),"Entregado"),
	            new OrderStatus(StatusType.TRANSIT.codigo(),"Transito")
	        );
	}
	
	@Override
    public Optional<OrderStatus> search(String codigo) {

        return Optional.ofNullable(statusTypes.get(codigo));
    }
}
