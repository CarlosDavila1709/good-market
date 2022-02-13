package store.market.backoffice.auth.domain;

import java.io.IOException;

import store.market.shared.infrastructure.config.ParameterNotExist;

public interface AuthToken {

	public String generarToken(String uid) throws IOException, ParameterNotExist;
	void validarToken(String token ) throws IOException, ParameterNotExist;
}
