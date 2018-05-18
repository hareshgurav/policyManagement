package com.policyPayment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.policyPayment.model.Payment;


public interface Paymentrepo extends MongoRepository<Payment, Integer> {
	
	public Payment insert(Payment payment);

}
