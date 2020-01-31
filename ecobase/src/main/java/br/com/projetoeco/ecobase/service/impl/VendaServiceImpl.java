package br.com.projetoeco.ecobase.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoeco.ecobase.entity.Venda;
import br.com.projetoeco.ecobase.repository.VendaRepository;
import br.com.projetoeco.ecobase.service.VendaService;

@Service
public class VendaServiceImpl implements VendaService {
	
	@Autowired
	private VendaRepository repository;
	
	@Override
	public Venda insertOrUpdate(Venda entity) {
		Venda vendaSalvo = this.repository.save(entity);
		return vendaSalvo;
	}
	
	@Override
	public void delete(int id) {
		this.repository.deleteById(id);
	}

	@Override
	public List<Venda> getAll() {
		return (List<Venda>) this.repository.findAll();
	}

	@Override
	public Venda getById(int id) {
		return this.repository.findById(id).orElse(null);
	}

	@Override
	public List<Venda> getAllById(int id) {
		return (List<Venda>)this.repository.findAllById(id);
	}
	
	@Override
	public Venda getVendaById(int id) {
		return this.repository.findVendaById(id);
	}


	@Override
	public List<Venda> insertOrUpdateAll(List<Venda> entities) {
		return (List<Venda>) this.repository.saveAll(entities);
	}
}
