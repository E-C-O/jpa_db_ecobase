package br.com.projetoeco.ecobase.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.projetoeco.ecobase.entity.Usuario;

public interface UsuarioRepository extends CrudRepository <Usuario, Integer> {

	List<Usuario> findAllByNome(String nome);
	Usuario findUsuarioByNome(String nome);
	
	List<Usuario> findUsuarioByEmail(String email);
	List<Usuario> findUsuarioBySenha(String senha);

}
