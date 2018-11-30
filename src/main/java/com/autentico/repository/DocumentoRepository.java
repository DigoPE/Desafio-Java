package com.autentico.repository;

import org.springframework.data.repository.CrudRepository;
import com.autentico.models.ComprovanteM;

public interface DocumentoRepository extends CrudRepository<ComprovanteM, String>{
	ComprovanteM findByidcomp(long idcomp);
}

