package CustomerList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import CustomerList.model.CustomerConditionModel;
import CustomerList.model.FindListModel;

@Controller
public class ListController {

	@Autowired
	FindListModel findListModel;
	
	@RequestMapping(value = "/List", method = RequestMethod.POST)
	public String List(CustomerConditionModel condition, Model model) {
		
		findListModel.FindList(condition);
		model.addAttribute("findListModel", findListModel);
		
		return "List";
	}
	
}

