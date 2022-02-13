package store.market.backoffice.auth.infrastructure.auth;

import store.market.backoffice.auth.domain.AuthToken;
import store.market.shared.domain.Service;
import store.market.shared.infrastructure.auth_token.Token;
import store.market.shared.infrastructure.config.Parameter;
import store.market.shared.infrastructure.config.ParameterNotExist;

@Service
public class SecurityToken implements AuthToken{

    private final Parameter config;
    
    private final Token token;
    
    public SecurityToken(Parameter config,Token token) {
    	this.config = config;
    	this.token = token;
    }
    
    public String generarToken(String uid) {
    	String _secret ="";
    	try {
    	
    		 _secret = config.get("BACKOFFICE_SECRET_TOKEN");
    		
		} catch (ParameterNotExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return token.generarToken(_secret,uid);

    }
    public void validarToken(String token) {

		try {
	    	
	    	String _secret = config.get("BACKOFFICE_SECRET_TOKEN");
	    	
	    	this.token.validarToken(token, _secret);
	    	
		} catch (ParameterNotExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    		
    }
}
