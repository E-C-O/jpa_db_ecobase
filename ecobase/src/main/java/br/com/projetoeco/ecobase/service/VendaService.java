package br.com.projetoeco.ecobase.service;

import java.util.List;

import br.com.projetoeco.ecobase.entity.Venda;

public interface VendaService {

	Venda insertOrUpdate(Venda entity);

	List<Venda> insertOrUpdateAll(List<Venda> entity);
	
	void delete(int id);
	
	List<Venda> getAll();
	
	Venda getById(int id);
	
	List<Venda> getAllById(int id);

	Venda getVendaById(int id);
	
}
