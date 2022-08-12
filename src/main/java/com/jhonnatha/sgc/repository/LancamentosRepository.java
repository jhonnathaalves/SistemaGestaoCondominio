package com.jhonnatha.sgc.repository;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.jhonnatha.sgc.domain.Lancamentos;

@Repository
public interface LancamentosRepository extends MongoRepository<Lancamentos, String> {
	
	List<Lancamentos> findAllByDataBetween(
		      Instant DataStart,
		      Instant DataEnd);
	
	@Query("{'data' : { $gte: ?0, $lte: ?1 } }") 
	List<Lancamentos> getObjectByDate(Date from, Date to);
	
	List<Lancamentos> findAllByOrderByIdDesc();

}
