package CustomerList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import CustomerList.model.CustomerConditionModel;
import CustomerList.model.CustomerInfoModelDAO;
import CustomerList.model.FindListModel;

@Controller
public class AddProgramController {
	@Autowired
	FindListModel findListModel;
	CustomerInfoModelDAO customerInfoModelDAO;
	
	@RequestMapping(value = "/AddProgram", method = RequestMethod.POST)
	public String AddProgram(CustomerConditionModel condition, Model model) {

		Integer count = findListModel.CustomerCheck(condition);
		if (count != 0) {
			findListModel.CustomerId(condition);
			model.addAttribute("message",
					"<p>登録済みです</p>"
					+ "<span>お客様番号：" + findListModel.getAllCustomerList().get(0).getCustomerId() + "</span>"
			);
			return "List";
		}
		
		Integer count1 = findListModel.AddProgram(condition);
		if (count1 != 1) {
			model.addAttribute("message", "新規登録できませんでした");
			return "AddCustomer";
		}
		
		findListModel.CustomerId(condition);
		model.addAttribute("message", 
		"<span>登録完了しました</span><br>"
		+ "<span>お客様番号：" + findListModel.getAllCustomerList().get(0).getCustomerId() + "</span>"
		);
		
		return "List";
		
	}
}
