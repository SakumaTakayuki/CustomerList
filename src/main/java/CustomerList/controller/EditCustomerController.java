package CustomerList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import CustomerList.model.CustomerConditionModel;
import CustomerList.model.FindListModel;

@Controller
public class EditCustomerController {
	
	@Autowired
	FindListModel findListModel;
	
	@RequestMapping(value = "/EditCustomer", method = RequestMethod.POST)
	String EditCustomer(CustomerConditionModel condition, Model model) {
		
		findListModel.EditCustomer(condition);
		model.addAttribute("CustomerId", findListModel.getAllCustomerList().get(0).getCustomerId());
		model.addAttribute("Name", findListModel.getAllCustomerList().get(0).getName());
		model.addAttribute("Tel", findListModel.getAllCustomerList().get(0).getTel());
		model.addAttribute("Duration", findListModel.getAllCustomerList().get(0).getDuration());
		model.addAttribute("Type", findListModel.getAllCustomerList().get(0).getType());
		model.addAttribute("Net", findListModel.getAllCustomerList().get(0).getNet());
		model.addAttribute("Memo", findListModel.getAllCustomerList().get(0).getMemo());
		
		return "EditCustomer";
		
	}

}
