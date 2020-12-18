package store.market.shared.infrastructure.hibernate;

import org.hibernate.SessionFactory;
import store.market.shared.domain.Identifier;
import store.market.shared.domain.criteria.Criteria;
import store.market.shared.domain.criteria.Filter;
import store.market.shared.domain.criteria.Filters;
import store.market.shared.domain.criteria.Order;

import javax.persistence.criteria.CriteriaQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class HibernateRepository<T> {
    protected final SessionFactory             sessionFactory;
    protected final Class<T>                   aggregateClass;
    protected final HibernateCriteriaConverter criteriaConverter;

    public HibernateRepository(SessionFactory sessionFactory, Class<T> aggregateClass) {
        this.sessionFactory    = sessionFactory;
        this.aggregateClass    = aggregateClass;
        this.criteriaConverter = new HibernateCriteriaConverter<T>(sessionFactory.getCriteriaBuilder());
    }

    protected void persist(T entity) {
        sessionFactory.getCurrentSession().saveOrUpdate(entity);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }
    protected void remover(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }
    protected Optional<T> byId(Identifier id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }

    protected List<T> byCriteria(Criteria criteria) {
        CriteriaQuery<T> hibernateCriteria = criteriaConverter.convert(criteria, aggregateClass);
        if(!criteria.limit().isPresent() || !criteria.offset().isPresent() ) {
            
        	 return sessionFactory.getCurrentSession().createQuery(hibernateCriteria).getResultList();

        }else {
        	int limit = criteria.limit().orElseGet(()->100000);
            int offset = criteria.offset().orElseGet(()->0);
            return sessionFactory.getCurrentSession().createQuery(hibernateCriteria)
    		        .setFirstResult(limit * offset)
            		.setMaxResults(limit)
    		        .getResultList();
        	
        }

    }
    protected List<T> byField(String field, String value) {
    	Filter filter = Filter.create(field, "=", value);
		List<Filter> filtersList = new ArrayList<Filter>();
		filtersList.add(filter);
		Filters filters = new Filters(filtersList);
		
		Criteria criteria = new Criteria(filters, Order.none(),Optional.empty(), Optional.empty());
		
		return byCriteria(criteria);
    }
    protected List<T> all() {
        CriteriaQuery<T> criteria = sessionFactory.getCriteriaBuilder().createQuery(aggregateClass);

        criteria.from(aggregateClass);

        return sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
    }
}
