package br.com.projetoeco.ecobase.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoeco.ecobase.entity.Login;
import br.com.projetoeco.ecobase.entity.Usuario;
import br.com.projetoeco.ecobase.service.LoginService;


@CrossOrigin("*")
@RestController
public class LoginController {
	
	
	@Autowired
	LoginService service;
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> login(@RequestBody Login login) {
		Usuario rt = service.login(login);
		if(rt == null) {
			return ResponseEntity.status(401).body(rt);
		}
		return ResponseEntity.status(202).body(rt);
	}
	
}