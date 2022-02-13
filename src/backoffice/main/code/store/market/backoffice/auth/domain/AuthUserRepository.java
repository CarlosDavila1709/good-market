package store.market.backoffice.auth.domain;

import java.util.List;
import java.util.Optional;

import store.market.shared.domain.criteria.Criteria;

public interface AuthUserRepository {

	
	void save(AuthUser user);
	
	Optional<AuthUser> search(AuthUserEmail email);
	
	List<AuthUser> matching(Criteria criteria);
	
    List<AuthUser> searchAll();
}
