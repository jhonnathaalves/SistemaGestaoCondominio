package com.jhonnatha.sgc.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jhonnatha.sgc.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	User findByEmail(String email);
	
	List<User> findAllByPerfisOrderByNomeAsc(String perfil);
	
	List<User> findAllByPerfisNotLikeOrderByNomeAsc(String perfil);

}
