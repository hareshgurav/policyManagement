package com.policy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.policy.model.UserPolicy;
import java.lang.Integer;
import java.util.List;
import java.lang.String;

public interface UserPolicyRepo extends MongoRepository<UserPolicy, Integer> {
	
	public UserPolicy insert(UserPolicy userpolicy);
	 
	public List<UserPolicy> findByUserid(Integer userid);
	
	List<UserPolicy> findByUserpolicyid(String userpolicyid);
  
}
