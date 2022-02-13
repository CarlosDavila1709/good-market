package store.market.backoffice.auth.domain;

import store.market.shared.domain.StringValueObject;

public final class AuthUserPassword extends StringValueObject{
	
	private final static Integer MIN_CARACTERES_PASSWORD = 5; 
	
	public AuthUserPassword() {
		super("");
	}
	
	public AuthUserPassword(String value) {
		
        super(value);
        ensurePasswordHasAtLeast5Charaters(value);
    }
	
	private void ensurePasswordHasAtLeast5Charaters(String password) {
		if( password.isEmpty() || password.length() <= MIN_CARACTERES_PASSWORD) {
			throw new RuntimeException("The password mayor de 5 charaters");
		}
	}
}
