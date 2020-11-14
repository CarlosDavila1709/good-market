package store.market.administration.customer.application.search_by_phone;

import store.market.administration.customer.application.CustomerResponse;

import store.market.shared.domain.Service;
import store.market.shared.domain.bus.query.QueryHandler;

@Service
public final class SearchCustomerByPhoneQueryHandler implements QueryHandler<SearchCustomerByPhoneQuery, CustomerResponse>{

	private final CustomerByPhoneSearch searcher;
	
	public SearchCustomerByPhoneQueryHandler(CustomerByPhoneSearch searcher) {
		
		this.searcher = searcher;
	}
	
    @Override
    public CustomerResponse handle(SearchCustomerByPhoneQuery query) {
        
	   return searcher.search(query.phone());
	   
    }
}
