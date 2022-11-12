package CustomerList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import CustomerList.model.ChangePassModel;
import CustomerList.model.CustomerInfoModelDAO;

@Controller
public class ChangePassController {
	
	@Autowired
	CustomerInfoModelDAO customerInfoModelDAO;
	
	@RequestMapping(value = "/ChangePass", method = RequestMethod.GET)
	public String ChangePass() {
		
		return "ChangePass";
		
	}
	
	@RequestMapping(value = "/ChangePass",params = {"UserId", "MasterKey", "NewPassword"}, method = RequestMethod.POST)
	public String ChangePass(
			@RequestParam(value = "UserId") String UserId,
			@RequestParam(value = "MasterKey") String MasterKey,
			@RequestParam(value = "NewPassword") String NewPassword,
			Model model) {
		
		Integer count = customerInfoModelDAO.CheckPass(new ChangePassModel(UserId, MasterKey, NewPassword));
		if (count != 1) {
			model.addAttribute("message", "ユーザーIDまたはマスターキーが違います");
			return "ChangePass";
		}
		
		Integer set = customerInfoModelDAO.ChangePass(new ChangePassModel(UserId, MasterKey, NewPassword));
		if (set != 1) {
			model.addAttribute("message", "変更できませんでした");
			return "ChangePass";
		}
		
		model.addAttribute("message", "パスワードを変更しました");
		return "Login";
		
	}

}
