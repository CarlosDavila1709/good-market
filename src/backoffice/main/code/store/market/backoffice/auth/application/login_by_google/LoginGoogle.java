package store.market.backoffice.auth.application.login_by_google;

import java.util.Map;

import store.market.backoffice.auth.application.TokenResponse;
import store.market.backoffice.auth.application.token_generate.GenerateToken;
import store.market.backoffice.auth.domain.AuthUser;
import store.market.backoffice.auth.domain.AuthUserEmail;
import store.market.backoffice.auth.domain.AuthUserId;
import store.market.backoffice.auth.domain.AuthUserPassword;
import store.market.backoffice.auth.domain.AuthUserRepository;
import store.market.backoffice.auth.domain.OAuthCompany;
import store.market.backoffice.auth.domain.TokenInvalidException;
import store.market.backoffice.auth.infrastructure.auth.SecurityGoogle;
import store.market.backoffice.grocery.application.GroceryResponse;
import store.market.backoffice.grocery.application.search.SearchGroceryQuery;
import store.market.backoffice.grocery.domain.GroceryId;
import store.market.backoffice.grocery.domain.GroceryNotExist;
import store.market.shared.domain.Service;
import store.market.shared.domain.UuidGenerator;
import store.market.shared.domain.bus.query.QueryBus;

@Service
public final class LoginGoogle {

	private final AuthUserRepository 	repository;
	private final SecurityGoogle 		google;
    private UuidGenerator            	uuidGenerator;
	private final GenerateToken 		token;
	private final static String OAUTH_GOOGLE = "google"; 
	private final QueryBus queryBus;
	
	public LoginGoogle(AuthUserRepository repository, UuidGenerator uuidGenerator, SecurityGoogle google, GenerateToken token, QueryBus queryBus) {
		
		this.repository 	= repository;
		this.google     	= google;
	    this.uuidGenerator 	= uuidGenerator;
	    this.token			= token;
	    this.queryBus		= queryBus;
	}
	
	public TokenResponse loguer(String googleToken, GroceryId idGrocery) {

		insureGroceryExist(idGrocery) ;
		
		Map<String, String> dataGoogle = validWithGoogle(googleToken);

		AuthUser userBD = repository.search(new AuthUserEmail(dataGoogle.get("email")))
												.orElseGet(() -> AuthUser.create(
														new AuthUserId(uuidGenerator.generate()), 
														new AuthUserEmail(dataGoogle.get("email")), 
														new AuthUserPassword("@@@@@@"), 
														idGrocery,
														new OAuthCompany(OAUTH_GOOGLE),
														true ));
		
		
		if(!userBD.oauthExternal()) {
			userBD.updateOauthCompany(new OAuthCompany(OAUTH_GOOGLE));
			userBD.updatePassword(new AuthUserPassword("@@@@@@"));
			userBD.updateOauthExternal(true);
		}
		
		repository.save(userBD);
		
		String tokenizer = token.generar(new AuthUserEmail(dataGoogle.get("email")));
		
		return new TokenResponse(tokenizer);
	}
	
	private Map<String, String> validWithGoogle(String googleToken) {
		
		Map<String, String> userGoogle = google.validar(googleToken);
		
		if(userGoogle.isEmpty()) {
			throw new TokenInvalidException(googleToken);
		}
		return userGoogle;
	}
	
	private void insureGroceryExist(GroceryId idGrocery) {
		
		GroceryResponse grocery = queryBus.ask(new SearchGroceryQuery(idGrocery.value()));
		
		if(grocery == null) {
			
			throw new GroceryNotExist(idGrocery);
		}
	}
}
