package com.oracle.policymgmt.client;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.oracle.policymgmt.model.Products;
import com.oracle.policymgmt.model.User;
import com.oracle.policymgmt.model.UserDetails;
import com.oracle.policymgmt.model.UserPolicy;

@Controller
public class WelcomeController {
	static int policy_id=12;
	
	@RequestMapping(value = "/login")
	public String message() {
		return "login";
	}
	
	@RequestMapping(value = "/register")
	public String register(@ModelAttribute("userDetails") UserDetails userDetails)
	{	
		return "register";
	}	

	@RequestMapping(value = "/welcome", method = RequestMethod.POST)
	public String login(HttpServletRequest req, HttpServletResponse res, Model mod) {
		RestTemplate restTemplate = new RestTemplate();
		String userId=req.getParameter("email");
		String password= req.getParameter("pass");
		User user = new User(userId, password,"");
		
		Boolean valid = restTemplate.postForObject("http://localhost:9091/validateusercreds", user, Boolean.class);
		if (valid) {
			
			mod.addAttribute("useremail", userId);
				List<UserPolicy> userpolicy=restTemplate.getForObject("http://localhost:9092/userpolicy/"+userId, List.class);
			mod.addAttribute("userpolicy",userpolicy);
			
			return "welcome";
		} else {
			mod.addAttribute("message","Invalid Username\\Password");
			
			return "login";
		}
	}
	
	
	
	@RequestMapping(value = "/registerUser", method=RequestMethod.POST)
	public String registerUser(@ModelAttribute("userDetails") UserDetails userDetails)
	{	
		RestTemplate restTemplate = new RestTemplate();	
		String resultString = restTemplate.postForObject("http://localhost:9091/registeruser", userDetails, String.class);
		System.out.println(resultString);
		return "registerSuccess";
	}
	
	
	@RequestMapping(value = "/getallproducts")
	public String getProducts(Model model)
	{	
		RestTemplate restTemplate = new RestTemplate();	
		List<Products> products = restTemplate.getForObject("http://localhost:9093/getAllProduct",List.class);
		System.out.println("COntroller "+products);
		model.addAttribute("products", products);
		return "buypolicy";
	}
	
	@RequestMapping(value="/buypolicy", method=RequestMethod.POST)
	public String buyPolicy(HttpServletRequest req, HttpServletResponse res)
	{
		System.out.println("tenure::"+ req.getParameter("tenure"));
		System.out.println("policyterm ::"+ req.getParameter("policyterm"));
		System.out.println("policylist:: "+ req.getParameter("policylist"));
		System.out.println("sumAssured:: "+ req.getParameter("sumAssured"));
		System.out.println("premiumAmt:: "+ req.getParameter("premiumAmt"));
		System.out.println("maturityDate:: "+ req.getParameter("maturityDate"));
		UserPolicy userPolicy =new UserPolicy();
		userPolicy.setUserId("nvasdev");
		userPolicy.setUser_Policy_Id("UP00"+policy_id);
		userPolicy.setProductId(req.getParameter("policylist"));
		userPolicy.setSumAssured(req.getParameter("sumAssured"));
		userPolicy.setMaturityDate(req.getParameter("maturityDate"));
		userPolicy.setPremiumFrequency( req.getParameter("policyterm"));
		userPolicy.setPremiumAmt(req.getParameter("premiumAmt"));
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		userPolicy.setPurchaseDate(sdf.format(new Date()));
		userPolicy.setPolicyStatus("Draft");
		
		RestTemplate restTemplate= new RestTemplate();
		String returnStatus=restTemplate.postForObject("http://localhost:9092/buynewpolicy", userPolicy, String.class);
				policy_id++;
				System.out.println(returnStatus);
		
		return "payment";
	}
	

}
