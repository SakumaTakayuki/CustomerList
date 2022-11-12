package CustomerList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import CustomerList.model.CustomerConditionModel;
import CustomerList.model.FindListModel;

@Controller
public class DeleteCustomerController {
	
	@Autowired
	FindListModel findListModel;
	
	@RequestMapping(value = "/DeleteCustomer", method = RequestMethod.POST)
	public String DeleteCustomer(CustomerConditionModel condition, Model model) {
		
		Integer count = findListModel.DeleteCustomer(condition);
		
		if (count != 1) {
			model.addAttribute("message", "削除できませんでした");
			return "List";
		}
		
		model.addAttribute("message", "削除しました");
		return "List";
		
	}

}
