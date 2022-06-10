package com.jhonnatha.sgc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jhonnatha.sgc.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	User findByEmail(String email);

}
