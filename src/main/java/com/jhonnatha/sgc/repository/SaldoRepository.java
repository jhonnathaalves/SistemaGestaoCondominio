package com.jhonnatha.sgc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jhonnatha.sgc.domain.Saldo;

@Repository
public interface SaldoRepository extends MongoRepository<Saldo, String> {
	
	Saldo findFirstByOrderByIdDesc();
	Saldo findFirstByOrderByIdAsc();	

}
