package br.com.projetoeco.ecobase.service;

import java.util.List;

import br.com.projetoeco.ecobase.entity.Usuario;

public interface UsuarioService {
	
	Usuario insertOrUpdate(Usuario entity);

	List<Usuario> insertOrUpdateAll(List<Usuario> entity);
	
	void delete(int id);
	
	List<Usuario> getAll();
	
	Usuario getById(int id);
	
	List<Usuario> getAllByNome(String nome);
	
	Usuario getByNome(String nome);
	

}
