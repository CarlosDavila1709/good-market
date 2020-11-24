package store.market.administration.categorie.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import store.market.administration.categorie.domain.Categorie;
import store.market.administration.categorie.domain.CategorieId;
import store.market.administration.categorie.domain.CategorieRepository;
import store.market.shared.domain.Service;
import store.market.shared.domain.criteria.Criteria;
import store.market.shared.infrastructure.hibernate.HibernateRepository;

@Service
@Transactional("administration-transaction_manager")
public final class PgSqlCategorieRepository extends HibernateRepository<Categorie> implements CategorieRepository {

    public PgSqlCategorieRepository(@Qualifier("administration-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Categorie.class);
    }

    @Override
    public void save(Categorie categorie) {
        persist(categorie);
    }

    @Override
    public List<Categorie> searchAll() {
        return all();
    }

    @Override
    public List<Categorie> matching(Criteria criteria) {
        return byCriteria(criteria);
    }

	@Override
	public Optional<Categorie> search(CategorieId id) {
		
		return byId(id);
	}
	
    @Override
    public void delete(Categorie categorie) {

    	remover(categorie);
    }
}
