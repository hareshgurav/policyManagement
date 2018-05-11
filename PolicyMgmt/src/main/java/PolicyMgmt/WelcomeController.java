package PolicyMgmt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {
	
	@RequestMapping("/login")
	public String message()
	{
		return "login";
	}
	
	
	@RequestMapping(value="/welcome", method= RequestMethod.POST)
	public String login(HttpServletRequest req, HttpServletResponse res, Model mod)
	{
		System.out.println("here "+ req.getParameter("email") + req.getParameter("pass"));
		mod.addAttribute("useremail",req.getParameter("email"));
		
		return "welcome";
	}

}
