package com.jhonnatha.sgc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jhonnatha.sgc.domain.Visitas;

@Repository
public interface VisitasRepository extends MongoRepository<Visitas,String> {

}
