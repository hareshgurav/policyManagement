package com.oracle.usermgmt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.oracle.usermgmt.model.User;

public interface UserManagementRepository extends MongoRepository<User, Long>{
	
	User findByuserid(String userid);

}
