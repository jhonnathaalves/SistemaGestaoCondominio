package com.jhonnatha.sgc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jhonnatha.sgc.domain.Ocorrencias;

@Repository
public interface OcorrenciasRepository extends MongoRepository<Ocorrencias, String> {

}
