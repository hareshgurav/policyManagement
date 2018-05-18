package com.policyPayment.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.policyPayment.model.Payment;
import com.policyPayment.model.UserPolicy;
import com.policyPayment.repository.Paymentrepo;



@RestController
public class PolicyPaymentController {
	
	@Autowired
	Paymentrepo paymentrepo;
	
	/*@Autowired
	PolicyDetailsProxy policyDetailsProxy;*/
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${policy.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${policy.rabbitmq.routingkey}")
	private String routingkey;	
	
		
	    @RequestMapping(value="/paypolicy", method=RequestMethod.POST)
		public String payforPolicy(@RequestBody Payment payment) {	
	    	System.out.println("Start method of policy payment");
		
		/*payment.setUserid(Integer.parseInt(req.getParameter("")));
		payment.setUserpolicyid(req.getParameter(""));
		payment.setAccountno(Integer.parseInt(req.getParameter("")));
		payment.setAmount(Integer.parseInt(req.getParameter("")));
		payment.setBankname(req.getParameter(""));
		payment.setPaymentstatus(req.getParameter(""));*/
		
		/*payment.setUserid(111);
		
		payment.setUserpolicyid("UP0016");
		payment.setAccountno(23455666);
		payment.setAmount(1220);
		payment.setBankname("BANK OF INDIA");
		payment.setPaymentstatus("SUCCESS");*/
		
		
		
		System.out.println("********* Payment Object :::"+payment.toString());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");;//dd/MM/yyyy
	    Date now = new Date();
	    String strDate = sdf.format(now);
	    System.out.println(strDate);
	    String transid=strDate.substring(7);
	    System.out.println("Payment id ************************* "+transid+"***** payment **"+payment.toString());
	   
		payment.setTransid(transid);
		Payment paymentvo = paymentrepo.insert(payment);
		
		// update status called
		UserPolicy userPolicy = new UserPolicy();
		userPolicy.setUserpolicyid(payment.getUserpolicyid());
		userPolicy.setPolicyStatus("APPROVED");
		//policyDetailsProxy.updatePolicyStatus(userPolicy);
		System.out.println("User Policy in policy pay ent"+userPolicy);
		amqpTemplate.convertAndSend(exchange, routingkey, userPolicy);
		
		return "SU";
	}
	
}
