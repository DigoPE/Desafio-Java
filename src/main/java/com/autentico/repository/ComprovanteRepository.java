package com.autentico.repository;

import org.springframework.data.repository.CrudRepository;

import com.autentico.models.ComprovanteM;
import com.autentico.models.DossieUsu;


public interface ComprovanteRepository extends CrudRepository<ComprovanteM, String>{
	Iterable<ComprovanteM> findByDossieUsu(DossieUsu dossieUsu);
	ComprovanteM findByidcomp(long idcomp);
}
