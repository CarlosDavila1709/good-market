package store.market.backoffice.auth.domain;

public final class InvalidAuthUsername extends RuntimeException {

    public InvalidAuthUsername(AuthUserEmail email) {
        super(String.format("The user <%s> does not exist", email.value()));
    }
}
