package com.jhonnatha.sgc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jhonnatha.sgc.domain.Blocos;

@Repository
public interface BlocosRepository extends MongoRepository<Blocos, String>  {

}
