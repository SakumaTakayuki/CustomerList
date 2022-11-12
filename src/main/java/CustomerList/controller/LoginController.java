package CustomerList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import CustomerList.model.CustomerInfoModelDAO;
import CustomerList.model.LoginModel;

@Controller
public class LoginController {
	
	@Autowired
	CustomerInfoModelDAO customerInfoModelDAO;
	
	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String Login() {
		
		return "Login";
	}
	
	@RequestMapping(value = "/Login", params = {"UserId", "Password"}, method = RequestMethod.POST)
	public String Login(
			@RequestParam(value = "UserId") String UserId,
			@RequestParam(value = "Password") String Password,
			Model model) {
		
		Integer count = customerInfoModelDAO.Login(new LoginModel(UserId, Password));
		
		if (count != 1) {
			model.addAttribute("message", "ユーザーIDもしくはパスワードが違います");
			return "Login";
		}
		
		return "List";
		
	}

}
