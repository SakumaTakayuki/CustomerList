package CustomerList.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BackController {
	
	@RequestMapping(value = "/Back", method = RequestMethod.GET)
	public String BackGet() {
		
		return "Login";
		
	}
	
	@RequestMapping(value = "/Back", method = RequestMethod.POST)
	public String BackPost() {
		
		return "List";
		
	}

}
