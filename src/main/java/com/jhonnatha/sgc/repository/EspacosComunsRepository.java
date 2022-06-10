package com.jhonnatha.sgc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jhonnatha.sgc.domain.EspacosComuns;

@Repository
public interface EspacosComunsRepository extends MongoRepository<EspacosComuns, String> {

}
