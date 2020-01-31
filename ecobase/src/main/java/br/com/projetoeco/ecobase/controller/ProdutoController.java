package br.com.projetoeco.ecobase.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoeco.ecobase.entity.Produto;
import br.com.projetoeco.ecobase.service.ProdutoService;

@RestController
@CrossOrigin("*")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@PostMapping("/produto")
	public ResponseEntity<Produto> post(@Valid @RequestBody Produto entity){
		try {
			Produto produtoSalvo = this.service.insertOrUpdate(entity);
			return ResponseEntity.ok(produtoSalvo);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@PostMapping("/produtos")
		public ResponseEntity <List<Produto>> postAll(@Valid @RequestBody List<Produto> produtos){
		try {
		List<Produto> produtoSalvo = this.service.insertOrUpdateAll(produtos);
			return ResponseEntity.ok(produtoSalvo);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
		
	
	@PutMapping("/produto")
	public ResponseEntity<Produto> put(@Valid @RequestBody Produto entity){
		try {
			Produto produtoSalvo = this.service.insertOrUpdate(entity);
			return ResponseEntity.ok(produtoSalvo);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@DeleteMapping("/produto/{id}")
	public ResponseEntity<String> delete(@Valid @PathVariable int id){
		if(this.service.getById(id) == null) {
			return ResponseEntity.notFound().build();
		}
		
		try {
			this.service.delete(id);
			return ResponseEntity.ok("Produto removido com sucesso!");
		} catch (Exception err) {
			return ResponseEntity.badRequest().body(err.getMessage());
		}
	}
	
	@GetMapping("/produto/{id}")
	public ResponseEntity<Produto> getById(@Valid @PathVariable int id){
		Produto produto = this.service.getById(id);
		
		if(produto == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(produto);
	}
	
	@GetMapping("/produto")
	public ResponseEntity<List<Produto>> getAll(){
		return ResponseEntity.ok(this.service.getAll());
	}
	
	@GetMapping("/produto/nome/{nome}")
	public ResponseEntity<List<Produto>> getAllByNome(@Valid @PathVariable String nome){
		return ResponseEntity.ok(this.service.getAllByNome(nome));
	}
	
}