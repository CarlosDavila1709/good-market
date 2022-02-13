package store.market.backoffice.auth.domain;

import java.util.Objects;

import store.market.backoffice.grocery.domain.GroceryId;
import store.market.shared.domain.AggregateRoot;

public final class AuthUser extends AggregateRoot {

	private final AuthUserId id;
    private final AuthUserEmail email;
    private AuthUserPassword password;
    private final GroceryId groceryId;
    private  OAuthCompany oauthCompany;
    private boolean oauthExternal;
    
    public AuthUser(AuthUserId id, AuthUserEmail email, AuthUserPassword password,GroceryId groceryId,OAuthCompany oauthCompany,boolean oauthExternal) {
    	this.id        		= id;
        this.email  		= email;
        this.password  		= password;
        this.groceryId 		= groceryId;
        this.oauthCompany	= oauthCompany;
        this.oauthExternal  = oauthExternal;
    }
    public AuthUser() {
    	this.id        		= null;
        this.email  		= null;
        this.password  		= null;
        this.groceryId 		= null;
        this.oauthCompany	= null;
        this.oauthExternal  = false;
    }
    
    public static AuthUser create(AuthUserId id, AuthUserEmail email, AuthUserPassword password, GroceryId idGrocery,OAuthCompany oauthCompany,boolean oauthExternal) {
    	
    	AuthUser authUser = new AuthUser(id, email, password, idGrocery,oauthCompany,oauthExternal);
    	return authUser;
    }
    
    public AuthUserId id() {
    	return id;
    }
    public AuthUserEmail email() {
        return email;
    }
    public AuthUserPassword password() {
    	return password;
    }
    public GroceryId  groceryId() {
    	return groceryId;
    }
    public OAuthCompany oauthCompany() {
    	return oauthCompany;
    }
    public boolean oauthExternal() {
    	return oauthExternal;
    }
    public void updateOauthCompany(OAuthCompany oauthCompany) {
    	this.oauthCompany = oauthCompany;
    }
    public void updatePassword(AuthUserPassword password) {
    	this.password = password;
    }
    public void updateOauthExternal(boolean oauthExternal) {
    	this.oauthExternal = oauthExternal;
    }
    public boolean passwordMatches(AuthUserPassword password) {
        return this.password.equals(password);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AuthUser authUser = (AuthUser) o;
        return id.equals(authUser.id) &&
               email.equals(authUser.email) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email,password,groceryId,oauthCompany,oauthExternal);
    }
}
