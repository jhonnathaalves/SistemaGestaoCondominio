package com.jhonnatha.sgc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jhonnatha.sgc.domain.Condominio;

@Repository
public interface CondominioRepository extends MongoRepository<Condominio, String>  {

}
