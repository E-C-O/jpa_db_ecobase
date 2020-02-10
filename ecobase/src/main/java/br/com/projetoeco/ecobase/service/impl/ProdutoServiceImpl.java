package br.com.projetoeco.ecobase.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoeco.ecobase.entity.Produto;
import br.com.projetoeco.ecobase.repository.ProdutoRepository;
import br.com.projetoeco.ecobase.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	@Override
	public Produto insertOrUpdate(Produto entity) {
		Produto produtoSalvo = this.repository.save(entity);
		return produtoSalvo;
	}
	
	@Override
	public void delete(int id) {
		this.repository.deleteById(id);
	}

	@Override
	public List<Produto> getAll() {
		return (List<Produto>) this.repository.findAll();
	}

	@Override
	public Produto getById(int id) {
		return this.repository.findById(id).orElse(null);
	}

	@Override
	public List<Produto> getAllByNome(String nome) {
		return (List<Produto>)this.repository.findAllByNome(nome);
	}
	
	@Override
	public Produto getByNome(String nome) {
		return this.repository.findProdutoByNome(nome);
	}


	@Override
	public List<Produto> insertOrUpdateAll(List<Produto> entities) {
		return (List<Produto>) this.repository.saveAll(entities);
	}

	@Override
	public List<Produto> getAllContain(String nome) {
		
		return this.repository.findByNomeContaining(nome);
	}


}
