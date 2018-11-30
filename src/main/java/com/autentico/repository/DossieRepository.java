package com.autentico.repository;

import org.springframework.data.repository.CrudRepository;
import com.autentico.models.DossieUsu;

public interface DossieRepository extends CrudRepository<DossieUsu, String> {
	DossieUsu findByMatricula(long matricula);
}
