package br.com.projetoeco.ecobase.service;

import java.util.List;

import br.com.projetoeco.ecobase.entity.Categoria;

public interface CategoriaService {

	Categoria insertOrUpdate(Categoria entity);

	List<Categoria> insertOrUpdateAll(List<Categoria> entity);
	
	void delete(int id);
	
	List<Categoria> getAll();
	
	Categoria getById(int id);
	
	List<Categoria> getAllByNome(String nome);
	
	Categoria getByNome(String nome);
}

