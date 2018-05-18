package com.policy.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.policy.model.PaymentDTO;
import com.policy.model.ProductMaster;
import com.policy.model.UserPolicy;
import com.policy.repository.ProductMasterRepo;
import com.policy.repository.UserPolicyRepo;

/*@RefreshScope*/
@RestController
@RequestMapping(name="policydetails")
public class PolicyDetails {
	
	@Autowired
	ProductMasterRepo productMasterRepo;	
	@Autowired
	UserPolicyRepo userPolicyRepo;
	//@Autowired
	/*PaymentServiceProxy paymentServiceProxy;*/
	
	
	@RequestMapping(value="/getallproduct")
	public List<ProductMaster> listallProduct(){		
		List<ProductMaster> productlist=productMasterRepo.findAll();
		return productlist;		
	}
	
	@RequestMapping(value="/getPolicyByUser/{userid}")
	public List<UserPolicy> listPolicyByUserId(@PathVariable Integer userid){		
		List<UserPolicy> userPolicyList=userPolicyRepo.findByUserid(userid);
		return userPolicyList;		
	}
	

	@RequestMapping(value="/getPolicyDetails/{userid}")
	public List<UserPolicy> getPolicyDetails(@PathVariable String policyid){		
		List<UserPolicy> userPolicyList=userPolicyRepo.findByUserpolicyid(policyid);
		return userPolicyList;		
	}
	
	 @RequestMapping("/dashboard/feign/{myself}")
	   public void findme(@PathVariable String myself){
		 System.out.println(" 11111 "+myself);
	      // paymentServiceProxy.sayHi(myself);
	       //paymentServiceProxy.sayhi();
	     
	   }
	
		
	@RequestMapping(value="/buyPolicy",method=RequestMethod.POST,headers= "Accept=application/json")
	public UserPolicy buyPolicy(@RequestBody UserPolicy userPolicy, @RequestHeader HttpHeaders headers) {		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String time = sdf.format(date);
		
		/*UserPolicy userpolicy = new UserPolicy();
		String User_Policy ="User123_"+product.getProductid();
		userpolicy.setUserpolicyid(User_Policy);
		userpolicy.setUserid(1233);
		userpolicy.setProductid(product.getProductid());
		userpolicy.setSumassured(45232);
		userpolicy.setMaturitydate("10_dec_2025");	
		userpolicy.setPremiumfrequency("Monthly");
		userpolicy.setPremiumamt(1250);
		userpolicy.setPurchasedate(time);
		userpolicy.setPolicyStatus("DRAFT");*/
		UserPolicy userpolicydb=userPolicyRepo.insert(userPolicy);
		System.out.println(" Product is inserted :"+userpolicydb.getId());		
		return userpolicydb;
		
	}
	
	@RequestMapping(value="/payPolicy",method=RequestMethod.POST,headers= "Accept=application/json")
	public String payPolicy(@RequestBody PaymentDTO payment) {
		//paymentServiceProxy.payforPolicy(payment);
		return "SU";
	}
	
	
	@RequestMapping(value="/updatePoStatus",method=RequestMethod.POST,headers= "Accept=application/json")
	public String updatePolicyStatus(@RequestBody UserPolicy userPolicy) {
		System.out.println("UpdateStatus called in Policy Management service********"+userPolicy.getUserpolicyid());
		
		List<UserPolicy> userPOList = userPolicyRepo.findByUserpolicyid(userPolicy.getUserpolicyid());
		UserPolicy userPolicyobj=null;
		for(UserPolicy obj :userPOList) {
			userPolicyobj=obj;
		}
		userPolicyobj.setUserpolicyid(userPolicy.getUserpolicyid());
		userPolicyobj.setPolicyStatus("APPROVED");
		userPolicyRepo.save(userPolicyobj);
		
		return "String";
	}

}
