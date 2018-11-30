package com.autentico.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.autentico.models.UsuariosM;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuariosM, String> {
	//UsuariosM findByusuid(String login);
	
	UsuariosM findByLogin(String login);
	
}
