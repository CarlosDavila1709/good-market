package store.market.administration.product.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import store.market.administration.product.domain.Product;
import store.market.administration.product.domain.ProductId;
import store.market.administration.product.domain.ProductRepository;
import store.market.shared.domain.Service;
import store.market.shared.domain.criteria.Criteria;
import store.market.shared.infrastructure.hibernate.HibernateRepository;

@Service
@Transactional("administration-transaction_manager")
public class PgSqlProductRepository  extends HibernateRepository<Product> implements ProductRepository{

    public PgSqlProductRepository(@Qualifier("administration-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Product.class);
    }

    @Override
    public void save(Product product) {
        persist(product);
    }

    @Override
    public List<Product> searchAll() {
        return all();
    }

    @Override
    public List<Product> matching(Criteria criteria) {
        return byCriteria(criteria);
    }
    
    @Override
    public Optional<Product> search(ProductId id) {
        return byId(id);
    }
}
