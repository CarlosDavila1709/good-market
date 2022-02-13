package store.market.backoffice.auth.application.find;

import store.market.shared.domain.bus.query.Query;

public class FindUserQuery implements Query{

	
    private final String email;

    public FindUserQuery(String email) {
        this.email = email;
    }

    public String email() {
        return email;
    }
}
