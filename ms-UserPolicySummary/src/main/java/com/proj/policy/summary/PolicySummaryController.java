package com.proj.policy.summary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	

}
