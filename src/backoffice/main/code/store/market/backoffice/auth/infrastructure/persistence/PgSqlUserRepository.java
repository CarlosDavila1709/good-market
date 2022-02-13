package store.market.backoffice.auth.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import store.market.backoffice.auth.domain.AuthUser;
import store.market.backoffice.auth.domain.AuthUserEmail;
import store.market.backoffice.auth.domain.AuthUserRepository;

import store.market.shared.domain.Service;
import store.market.shared.domain.criteria.Criteria;
import store.market.shared.infrastructure.hibernate.HibernateRepository;

@Service
@Transactional("backoffice-transaction_manager")
public class PgSqlUserRepository extends HibernateRepository<AuthUser> implements AuthUserRepository{

	public PgSqlUserRepository(@Qualifier("backoffice-session_factory") SessionFactory sessionFactory) {
		super(sessionFactory,AuthUser.class);
	}

    @Override
    public void save(AuthUser user) {
        persist(user);
    }

    @Override
    public Optional<AuthUser> search(AuthUserEmail email) {
    	List<AuthUser> list = byField("email",email.value());
    	
    	if(list.size()>0) {
    		return Optional.of(list.get(0));
    	}
    	return Optional.ofNullable(null); 
    	
    }

    @Override
    public List<AuthUser> matching(Criteria criteria) {
        return byCriteria(criteria);
    }

	@Override
	public List<AuthUser> searchAll() {
		
		return all();
	}
}
