package store.market.backoffice.auth.domain;

public final class InvalidAuthCredentials extends RuntimeException  {

	public InvalidAuthCredentials(AuthUserEmail email) {
        super(String.format("The credentials for <%s> are invalid", email.value()));
    }
}
