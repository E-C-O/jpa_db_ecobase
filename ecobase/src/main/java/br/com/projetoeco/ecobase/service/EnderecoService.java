package br.com.projetoeco.ecobase.service;

import java.util.List;

import br.com.projetoeco.ecobase.entity.Endereco;

public interface EnderecoService {
	
	Endereco insertOrUpdate(Endereco entity);

	List<Endereco> insertOrUpdateAll(List<Endereco> entity);
	
	void delete(int id);
	
	List<Endereco> getAll();
	
	Endereco getById(int id);
	
	List<Endereco> getAllByRua(String rua);
	
	Endereco getByRua(String rua);

}
