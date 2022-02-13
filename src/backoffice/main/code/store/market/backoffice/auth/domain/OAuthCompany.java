package store.market.backoffice.auth.domain;

import store.market.shared.domain.StringValueObject;

public final class OAuthCompany extends StringValueObject{

	public OAuthCompany() {
		super("");
	}
	public OAuthCompany(String value) {
		super(value);
	}
}
