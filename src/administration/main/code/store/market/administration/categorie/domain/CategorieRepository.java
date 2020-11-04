package store.market.administration.categorie.domain;

import java.util.List;
import java.util.Optional;

import store.market.shared.domain.criteria.Criteria;

public interface CategorieRepository {

    void save(Categorie categorie);

    List<Categorie> searchAll();

    List<Categorie> matching(Criteria criteria);
    
    Optional<Categorie> search(CategorieId id);
}
