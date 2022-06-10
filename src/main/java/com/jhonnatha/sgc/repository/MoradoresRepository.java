package com.jhonnatha.sgc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jhonnatha.sgc.domain.Moradores;

@Repository
public interface MoradoresRepository extends MongoRepository<Moradores, String> {

}
