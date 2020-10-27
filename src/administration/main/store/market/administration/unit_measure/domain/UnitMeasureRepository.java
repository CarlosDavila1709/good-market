package store.market.administration.unit_measure.domain;

import java.util.List;

import store.market.shared.domain.criteria.Criteria;

public interface UnitMeasureRepository {

    void save(UnitMeasure unitMeasure);

    List<UnitMeasure> searchAll();

    List<UnitMeasure> matching(Criteria criteria);
    
}
