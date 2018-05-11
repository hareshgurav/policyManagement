package com.oracle.usermgmt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.oracle.usermgmt.model.UserDetails;

public interface UserDetailsRepository extends MongoRepository<UserDetails, String> {
}
