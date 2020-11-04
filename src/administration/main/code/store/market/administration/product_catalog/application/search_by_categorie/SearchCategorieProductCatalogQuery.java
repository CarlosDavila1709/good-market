package store.market.administration.product_catalog.application.search_by_categorie;

import java.util.Objects;

import store.market.shared.domain.bus.query.Query;

public final class SearchCategorieProductCatalogQuery implements Query{

	private final String categorieId;
	
	public SearchCategorieProductCatalogQuery(String categorieId) {
		
		this.categorieId = categorieId;
	}
	public String categorieId() {
		return categorieId;
	}
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SearchCategorieProductCatalogQuery that = (SearchCategorieProductCatalogQuery) o;
        return categorieId.equals(that.categorieId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categorieId);
    }
}
