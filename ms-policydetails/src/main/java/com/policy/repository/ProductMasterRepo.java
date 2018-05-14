package com.policy.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.policy.model.ProductMaster;

@Repository
public interface ProductMasterRepo extends MongoRepository<ProductMaster, Integer> {
	
	public List<ProductMaster> findAll();

}
