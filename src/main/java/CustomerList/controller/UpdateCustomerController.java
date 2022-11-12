package CustomerList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import CustomerList.model.CustomerConditionModel;
import CustomerList.model.FindListModel;

@Controller
public class UpdateCustomerController {
	
	@Autowired
	FindListModel findListModel;
	
	@RequestMapping(value = "/UpdateCustomer", method = RequestMethod.POST)
	public String UpdateCustomer(CustomerConditionModel condition, Model model) {
		
		Integer count = findListModel.UpdateCustomer(condition);
		
		if(count != 1) {
			model.addAttribute("message", "更新できませんでした");			
		}
		
		model.addAttribute("message", "更新しました");
		return "List";
		
	}

}
