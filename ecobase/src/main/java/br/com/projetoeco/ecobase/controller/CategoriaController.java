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

import br.com.projetoeco.ecobase.entity.Categoria;
import br.com.projetoeco.ecobase.service.CategoriaService;

@RestController
@CrossOrigin("*")
public class CategoriaController {
	
	@Autowired
	private CategoriaService service;
	
	@PostMapping("/categoria")
	public ResponseEntity<Categoria> post(@Valid @RequestBody Categoria entity){
		try {
			Categoria categoriaSalvo = this.service.insertOrUpdate(entity);
			return ResponseEntity.ok(categoriaSalvo);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@PostMapping("/categorias")
		public ResponseEntity <List<Categoria>> postAll(@Valid @RequestBody List<Categoria> categorias){
		try {
		List<Categoria> categoriaSalvo = this.service.insertOrUpdateAll(categorias);
			return ResponseEntity.ok(categoriaSalvo);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
		
	
	@PutMapping("/categoria")
	public ResponseEntity<Categoria> put(@Valid @RequestBody Categoria entity){
		try {
			Categoria categoriaSalvo = this.service.insertOrUpdate(entity);
			return ResponseEntity.ok(categoriaSalvo);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@DeleteMapping("/categoria/{id}")
	public ResponseEntity<String> delete(@Valid @PathVariable int id){
		if(this.service.getById(id) == null) {
			return ResponseEntity.notFound().build();
		}
		
		try {
			this.service.delete(id);
			return ResponseEntity.ok("Categoria removida com sucesso!");
		} catch (Exception err) {
			return ResponseEntity.badRequest().body(err.getMessage());
		}
	}
	
	@GetMapping("/categoria/{id}")
	public ResponseEntity<Categoria> getById(@Valid @PathVariable int id){
		Categoria categoria = this.service.getById(id);
		
		if(categoria == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(categoria);
	}
	
	@GetMapping("/categoria")
	public ResponseEntity<List<Categoria>> getAll(){
		return ResponseEntity.ok(this.service.getAll());
	}
	
	@GetMapping("/categoria/nome/{nome}")
	public ResponseEntity<List<Categoria>> getAllByNome(@Valid @PathVariable String nome){
		return ResponseEntity.ok(this.service.getAllByNome(nome));
	}
	
}
