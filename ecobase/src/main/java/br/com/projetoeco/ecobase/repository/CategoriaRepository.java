package br.com.projetoeco.ecobase.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.projetoeco.ecobase.entity.Categoria;

public interface CategoriaRepository extends CrudRepository <Categoria, Integer>{
	
	List<Categoria> findAllByNome(String nome);
	Categoria findUsuarioByNome(String nome);

}