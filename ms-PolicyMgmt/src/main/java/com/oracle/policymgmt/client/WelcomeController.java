package com.oracle.policymgmt.client;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.oracle.policmgmt.redis.RedisRepository;
import com.oracle.policymgmt.model.Products;
import com.oracle.policymgmt.model.User;
import com.oracle.policymgmt.model.UserDetails;
import com.oracle.policymgmt.model.UserPolicy;

@Controller
public class WelcomeController {
	
	@Autowired
    private RedisRepository redisRepository;

	@Autowired
	public RestTemplate restTemplate;

	static int policy_id = 12;

	@RequestMapping(value = "/login")
	public String message() {
		System.out.println("<<<< In message controller:: login method >>>>");
		return "login";
	}

	@RequestMapping(value = "/register")
	public String register(@ModelAttribute("userDetails") UserDetails userDetails) {
		return "register";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.POST)
	public String login(HttpServletRequest req, HttpServletResponse res, Model mod) {
		
		System.out.println("<<<< In welcome controller:: login method >>>>");
		String userId = req.getParameter("email");
		String password = req.getParameter("pass");
		User user = new User(userId, password, "");
		Boolean valid = restTemplate.postForObject("http://localhost:8093/userMgmt/validateusercreds", user,
				Boolean.class);
		if (valid) {
			redisRepository.add(user);
			mod.addAttribute("useremail", userId);
			List<UserPolicy> userpolicy = restTemplate
					.getForObject("http://localhost:8093/userPolicyMgmt/userpolicy/" + userId, List.class);
			mod.addAttribute("userpolicy", userpolicy);

			return "welcome";
		} else {
			mod.addAttribute("message", "Invalid Username\\Password");

			return "login";
		}
	}
	
	
	@RequestMapping(value = "/showuserpolicies")
	public String showUserPolicies(Model mod)
	{
		Map<Object, Object> user = redisRepository.findAllUsers();
		String userId = (String) user.get("sessionUser");
		System.out.println("User id Is : "+userId);
		List<UserPolicy> userpolicy = restTemplate.getForObject("http://localhost:8093/userPolicyMgmt/userpolicy/" + userId, List.class);
		mod.addAttribute("userpolicy",userpolicy);
		mod.addAttribute("useremail", userId);
		return "welcome";
	}
	
	
	
	
	
	

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("userDetails") UserDetails userDetails) {
		String resultString = restTemplate.postForObject("http://localhost:8093/userMgmt/registeruser", userDetails,
				String.class);
		System.out.println(resultString);
		return "registerSuccess";
	}

	@RequestMapping(value = "/getallproducts")
	public String getProducts(Model model) {
		List<Products> products = restTemplate.getForObject("http://localhost:8093/allpolicies/getallproduct",
				List.class);
		System.out.println("COntroller " + products);
		model.addAttribute("products", products);
		return "buypolicy";
	}

	@RequestMapping(value = "/buypolicy", method = RequestMethod.POST)
	public String buyPolicy(HttpServletRequest req, HttpServletResponse res) {

		Map<Object, Object> user = redisRepository.findAllUsers();
		String userId = (String) user.get("sessionUser");
		UserPolicy userPolicy = new UserPolicy();
		userPolicy.setUserId(userId);
		userPolicy.setUser_Policy_Id("UP00" + policy_id);
		userPolicy.setProductId(req.getParameter("policylist"));
		userPolicy.setSumAssured(req.getParameter("sumAssured"));
		userPolicy.setMaturityDate(req.getParameter("maturityDate"));
		userPolicy.setPremiumFrequency(req.getParameter("policyterm"));
		userPolicy.setPremiumAmt(req.getParameter("premiumAmt"));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		userPolicy.setPurchaseDate(sdf.format(new Date()));
		userPolicy.setPolicyStatus("Draft");

		String returnStatus = restTemplate.postForObject("http://localhost:9092/buynewpolicy", userPolicy,
				String.class);
		policy_id++;
		System.out.println(returnStatus);

		return "payment";
	}

	@RequestMapping(value = "/userpolicy/{userId}")
	public String getUserPolicy(@PathVariable("userId") String userId, Model mod) {
		List<UserPolicy> userpolicy = restTemplate.getForObject("http://localhost:9092/userpolicy/" + userId,
				List.class);
		mod.addAttribute("userpolicy", userpolicy);

		return "welcome";

	}

}
