package br.com.projetoeco.ecobase.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoeco.ecobase.entity.Login;
import br.com.projetoeco.ecobase.entity.Usuario;
import br.com.projetoeco.ecobase.repository.UsuarioRepository;
import br.com.projetoeco.ecobase.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	UsuarioRepository repository;
	
	
	@Override
	public Usuario login(Login login) {
		
		List<Usuario> users = this.repository.findUsuarioByEmail(login.getEmail());
		if(users.size() == 0)
			return null;
		Usuario user = this.repository.findUsuarioByEmail(login.getEmail()).get(0);
		
		if(user.getSenha().equals(login.getSenha()))
			return user;
		
		return null;
	}
}
