package com.policy.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.policy.model.PaymentDTO;


/*@FeignClient(name="PaymentService" , url="http://localhost:8089")*/
public interface PaymentServiceProxy {
	
	/*@RequestMapping("/sayhi/{sample}")
	public void sayHi(@PathVariable(value="sample") String sample);*/
	
	@RequestMapping(value="/sayhi",method=RequestMethod.GET)
	public void sayhi();
	
	

	@RequestMapping(value="/payPolicy",method=RequestMethod.POST,headers= "Accept=application/json")
	public String payforPolicy(@RequestBody PaymentDTO payment);

}
