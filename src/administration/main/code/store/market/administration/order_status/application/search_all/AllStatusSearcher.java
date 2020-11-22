package store.market.administration.order_status.application.search_all;

import java.util.stream.Collectors;

import store.market.administration.order_status.application.StatusOrderResponse;
import store.market.administration.order_status.application.StatusOrdersResponse;
import store.market.administration.order_status.domain.StatusOrderRepository;
import store.market.shared.domain.Service;

@Service
public final class AllStatusSearcher {

	private final StatusOrderRepository repository;
	
	public AllStatusSearcher(StatusOrderRepository repository) {
		
		this.repository = repository;
	}
	
	public StatusOrdersResponse search() {

		return new StatusOrdersResponse(
				
			repository.searchAll().stream().map(StatusOrderResponse::fromAggregate).collect(Collectors.toList())

		);

	}
}
