package com.jhonnatha.sgc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jhonnatha.sgc.domain.Documentos;

@Repository
public interface DocumentosRepository extends MongoRepository<Documentos, String> {

}
