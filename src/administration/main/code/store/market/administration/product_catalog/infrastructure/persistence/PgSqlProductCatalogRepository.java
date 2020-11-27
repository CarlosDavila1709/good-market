package store.market.administration.product_catalog.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import store.market.administration.product_catalog.domain.ProductCatalog;
import store.market.administration.product_catalog.domain.ProductCatalogId;
import store.market.administration.product_catalog.domain.ProductCatalogRepository;
import store.market.shared.domain.Service;
import store.market.shared.domain.criteria.Criteria;
import store.market.shared.infrastructure.hibernate.HibernateRepository;

@Service
@Transactional("administration-transaction_manager")
public class PgSqlProductCatalogRepository extends HibernateRepository<ProductCatalog> implements ProductCatalogRepository {

	public PgSqlProductCatalogRepository(@Qualifier("administration-session_factory") SessionFactory sessionFactory) {
		
		super(sessionFactory, ProductCatalog.class);
		
	}
	
    @Override
    public void save(ProductCatalog productCatalog) {
        
    	persist(productCatalog);
    }

    @Override
    public List<ProductCatalog> searchAll() {
        return all();
    }

    @Override
    public List<ProductCatalog> matching(Criteria criteria) {
        return byCriteria(criteria);
    }
    
    @Override
    public Optional<ProductCatalog> search(ProductCatalogId id) {
        return byId(id);
    }

	@Override
	public void delete(ProductCatalog product) {
		remover(product);
	}
}
