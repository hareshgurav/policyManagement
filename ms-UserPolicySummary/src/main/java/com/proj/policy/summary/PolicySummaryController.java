package com.proj.policy.summary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proj.policy.summary.model.UserPolicy;
import com.proj.policy.summary.service.UserPolicyService;

@RestController
public class PolicySummaryController {

	@Autowired
	private UserPolicyService userPolicyService;

	@RequestMapping(value = "/userpolicy")
	public List<UserPolicy> policySummary() {
		List<UserPolicy> policies = null;
		try {

			policies = userPolicyService.findAll();

			System.out.println("policies findAll =" + policies);

			// fetch all user policies
			System.out.println("-------------------------------");
			for (UserPolicy policy : policies) {
				System.out.println("in iteration..");
				System.out.println(policy);
			}
			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return policies;
	}

	@RequestMapping(value = "/userpolicy/{uid}")
	public List<UserPolicy> policySummaryByUserId(@PathVariable String uid) {
		List<UserPolicy> policies = null;
		try {

			policies = userPolicyService.findByUserId(uid);

			System.out.println("policies findByUserId(" + uid + ")=" + policies);

			// fetch
			System.out.println("User Policies found with findByUserId:");
			System.out.println("-------------------------------");
			for (UserPolicy policy : policies) {
				System.out.println("in iteration..");
				System.out.println(policy);
			}
			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return policies;
	}
	
	@RequestMapping(value="/buynewpolicy")
	public String  buyNewPolicy(@RequestBody UserPolicy userPolicy)
	{
		try {
			userPolicyService.save(userPolicy);
		}catch (Exception e) {
			e.printStackTrace();
			return "FAILURE";
		}
		return "SUCCESS";
		
	}
	
	
	@RabbitListener(queues="${policy.rabbitmq.queue}")
    public void recievedMessage(final Message  msg) {
        System.out.println("Recieved Message: " +msg);
        System.out.println("Recieved Message with body: " +new String(msg.getBody()));
        
        
        
        try {
        byte[] mapData = new String(msg.getBody()).getBytes();
        Map<String,String> myMap = new HashMap<String, String>();

        ObjectMapper objectMapper = new ObjectMapper();
        myMap = objectMapper.readValue(mapData, HashMap.class);
        System.out.println("Map is: "+myMap.get("userpolicyid"));
        String userpolicyid=myMap.get("userpolicyid");
        System.out.println("new changes **************"+userpolicyid);
        
        UserPolicy userPolicy = userPolicyService.findByUserPolicyId(userpolicyid);

		System.out.println("userpolicyid - " + userpolicyid);
		userPolicy.setUser_Policy_Id(userpolicyid);
        userPolicy.setPolicyStatus("APPROVED");
        userPolicyService.save(userPolicy);
        } catch(Exception e) {
        	System.out.println(e);
        }
        
        
    }
	

}
