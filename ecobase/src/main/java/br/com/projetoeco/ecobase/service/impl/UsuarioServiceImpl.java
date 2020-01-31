package br.com.projetoeco.ecobase.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoeco.ecobase.entity.Usuario;
import br.com.projetoeco.ecobase.repository.UsuarioRepository;
import br.com.projetoeco.ecobase.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public Usuario insertOrUpdate(Usuario entity) {
		Usuario usuarioSalvo = this.repository.save(entity);
		return usuarioSalvo;
	}
	
	@Override
	public void delete(int id) {
		this.repository.deleteById(id);
	}

	@Override
	public List<Usuario> getAll() {
		return (List<Usuario>) this.repository.findAll();
	}

	@Override
	public Usuario getById(int id) {
		return this.repository.findById(id).orElse(null);
	}

	@Override
	public List<Usuario> getAllByNome(String nome) {
		return (List<Usuario>)this.repository.findAllByNome(nome);
	}
	
	@Override
	public Usuario getByNome(String nome) {
		return this.repository.findUsuarioByNome(nome);
	}


	@Override
	public List<Usuario> insertOrUpdateAll(List<Usuario> entities) {
		return (List<Usuario>) this.repository.saveAll(entities);
	}
}