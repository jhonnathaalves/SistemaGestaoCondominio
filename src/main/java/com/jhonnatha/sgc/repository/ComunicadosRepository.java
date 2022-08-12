package com.jhonnatha.sgc.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jhonnatha.sgc.domain.Comunicados;

@Repository
public interface ComunicadosRepository extends MongoRepository<Comunicados, String> {
	
	List<Comunicados> findAllByOrderByIdDesc();

}
