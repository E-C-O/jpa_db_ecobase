package br.com.projetoeco.ecobase.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.projetoeco.ecobase.entity.Venda;

public interface VendaRepository extends CrudRepository <Venda, Integer> {

	List<Venda> findAllById(int id);
	Venda findVendaById(int id);

}
