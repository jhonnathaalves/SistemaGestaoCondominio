package com.jhonnatha.sgc.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jhonnatha.sgc.domain.Agendamentos;

@Repository
public interface AgendamentosRepository extends MongoRepository<Agendamentos, String>  {
	
	List<Agendamentos> findAllByOrderByIdDesc();

}
