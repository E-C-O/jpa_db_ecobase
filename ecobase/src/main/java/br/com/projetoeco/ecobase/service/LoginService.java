package br.com.projetoeco.ecobase.service;

import br.com.projetoeco.ecobase.entity.Login;
import br.com.projetoeco.ecobase.entity.Usuario;

public interface LoginService {
	
	Usuario login(Login login);

}
