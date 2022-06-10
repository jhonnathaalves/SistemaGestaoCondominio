package com.jhonnatha.sgc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jhonnatha.sgc.domain.Unidades;

@Repository
public interface UnidadesRepository extends MongoRepository<Unidades, String> {

}
