package store.market.administration.unit_measure.infrastructure.persistence;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import store.market.administration.unit_measure.domain.UnitMeasure;
import store.market.administration.unit_measure.domain.UnitMeasureRepository;
import store.market.shared.domain.Service;
import store.market.shared.domain.criteria.Criteria;
import store.market.shared.infrastructure.hibernate.HibernateRepository;

@Service
@Transactional("administration-transaction_manager")
public final class PgSqlUnitMeasureRepository extends HibernateRepository<UnitMeasure> implements UnitMeasureRepository{

	public PgSqlUnitMeasureRepository(@Qualifier("administration-session_factory") SessionFactory sessionFactory) {
		
		 super(sessionFactory, UnitMeasure.class);
	}
	
	@Override
	public void save(UnitMeasure unitMeasure) {
		
		persist(unitMeasure);
		
	}

	@Override
	public List<UnitMeasure> searchAll() {
		 return all();
	}

	@Override
	public List<UnitMeasure> matching(Criteria criteria) {
		return byCriteria(criteria);
	}

}
