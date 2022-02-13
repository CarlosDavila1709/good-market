package store.market.shared.infrastructure.auth_google;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

import store.market.shared.domain.Service;

@Service
public final class GoogleVerify {
	
  
    public Map<String, String>  verifyByToken(String googleId, String idTokenString) {
    	
    	Map<String, String> map = new HashMap<String, String>();
    	
    	try {
    		
        	GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), JacksonFactory.getDefaultInstance())
        		    .setAudience(Collections.singletonList(googleId))
        		    .build();
        	GoogleIdToken idToken = verifier.verify(idTokenString);
        	if (idToken != null) {
        		  Payload payload = idToken.getPayload();

        		  // Print user identifier
        		  String userId = payload.getSubject();
        		  System.out.println("User ID: " + userId);

        		  // Get profile information from payload
        		  String email = payload.getEmail();
        		  boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
        		  String name = (String) payload.get("name");
        		  String pictureUrl = (String) payload.get("picture");
        		  String locale = (String) payload.get("locale");
        		  String familyName = (String) payload.get("family_name");
        		  String givenName = (String) payload.get("given_name");

        		  System.out.println("email: "+email);
        		  System.out.println("emailVerified: "+emailVerified);
        		  System.out.println("name: "+name);
        		  System.out.println("pictureUrl: "+pictureUrl);
        		  System.out.println("locale: "+locale);
        		  System.out.println("familyName: "+familyName);
        		  System.out.println("givenName: "+givenName);
        		  
        		  map.put("email", email);
        		  //map.put("emailVerified", emailVerified);
        		  map.put("name", name);
        		  map.put("pictureUrl", pictureUrl);
        		  map.put("locale", locale);
        		  map.put("familyName", familyName);
        		  map.put("givenName", givenName);

    		} else {
    		  System.out.println("Invalid ID token.");
    		 
    		}
    		
    	}catch( GeneralSecurityException  exception) {
    		
    		try {
				throw new GeneralSecurityException();
			} catch (GeneralSecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				throw new GeneralSecurityException(e.getMessage());
			} catch (GeneralSecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
    	

    	
    	return map;
	}
}
