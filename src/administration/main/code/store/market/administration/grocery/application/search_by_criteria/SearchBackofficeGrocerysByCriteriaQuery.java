package store.market.administration.grocery.application.search_by_criteria;

import store.market.shared.domain.bus.query.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public final class SearchBackofficeGrocerysByCriteriaQuery implements Query {

	private final List<HashMap<String, String>> filters;
	private final Optional<String> orderBy;
	private final Optional<String> orderType;
	private final Optional<Integer> limit;
	private final Optional<Integer> offset;

	public SearchBackofficeGrocerysByCriteriaQuery(List<HashMap<String, String>> filters, Optional<String> orderBy,
			Optional<String> orderType, Optional<Integer> limit, Optional<Integer> offset) {
		this.filters = filters;
		this.orderBy = orderBy;
		this.orderType = orderType;
		this.limit = limit;
		this.offset = offset;
	}

	public List<HashMap<String, String>> filters() {
		return filters;
	}

	public Optional<String> orderBy() {
		return orderBy;
	}

	public Optional<String> orderType() {
		return orderType;
	}

	public Optional<Integer> limit() {
		return limit;
	}

	public Optional<Integer> offset() {
		return offset;
	}
}