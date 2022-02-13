package store.market.backoffice.auth.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import store.market.shared.domain.StringValueObject;

public final class AuthUserEmail extends StringValueObject{
	private Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	
	public AuthUserEmail() {
		super("");
	}
	public AuthUserEmail(String value) {
		super(value);
		ensureValidEmailFormat(value);
	}
	
	private void ensureValidEmailFormat(String email) {
		Matcher mather = pattern.matcher(email);
		if( !mather.find() ) {
			throw new EmailFormatIncorrectException(this);
		}
	}
}
