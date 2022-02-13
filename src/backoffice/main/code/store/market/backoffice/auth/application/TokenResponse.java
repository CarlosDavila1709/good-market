package store.market.backoffice.auth.application;

import java.util.Objects;

import store.market.shared.domain.bus.query.Response;

public final class TokenResponse implements Response{

	private String code;
	
	public TokenResponse(String code) {
		
		this.code = code;
	}
	public String code() {
		return code;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TokenResponse that = (TokenResponse) o;
        return code.equals(that.code);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
