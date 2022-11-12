package CustomerList.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddCustomerController {
	
	@RequestMapping(value = "/AddCustomer", method = RequestMethod.POST)
	public String AddCustomer() {
		return "AddCustomer";
	}

}
