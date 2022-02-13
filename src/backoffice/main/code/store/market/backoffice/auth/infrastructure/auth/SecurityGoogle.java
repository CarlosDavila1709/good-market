package store.market.backoffice.auth.infrastructure.auth;

import java.util.HashMap;
import java.util.Map;

import store.market.shared.domain.Service;
import store.market.shared.infrastructure.auth_google.GoogleVerify;
import store.market.shared.infrastructure.config.Parameter;
import store.market.shared.infrastructure.config.ParameterNotExist;

@Service
public final class SecurityGoogle {

    private final Parameter config;
    private final GoogleVerify google;
    
    public SecurityGoogle(Parameter config,GoogleVerify google) {
    	this.config = config;
    	this.google = google;
    }
    
	public Map<String, String> validar(String token) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			map = this.google.verifyByToken(this.config.get("BACKOFFICE_GOOGLE_ID"), token);
		}catch (ParameterNotExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return map;
	}
}
