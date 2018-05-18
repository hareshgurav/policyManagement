package com.proj.policy.summary.service;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.proj.policy.summary.model.UserPolicy;

public interface UserPolicyService extends MongoRepository<UserPolicy, Integer> {

	public List<UserPolicy> findAll();

	public List<UserPolicy> findByUserId(String userId);
	
	public UserPolicy findByUserPolicyId(String userpolicyId);

}
