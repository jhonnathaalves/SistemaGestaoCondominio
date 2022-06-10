package com.jhonnatha.sgc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jhonnatha.sgc.domain.Colaboradores;

@Repository
public interface ColaboradoresRepository extends MongoRepository <Colaboradores,String> {

}
