package CustomerList.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class FindListModel {
	
	private List<CustomerInfoModel> AllCustomerList;
	
	@Autowired
	private CustomerInfoModelDAO customerInfoModelDAO;
	
	public FindListModel() {
		
	}
	
	public List<CustomerInfoModel> getAllCustomerList() {
		return AllCustomerList;
	}
	public void setAllCustomerList(List<CustomerInfoModel> AllCustomerList) {
		this.AllCustomerList = AllCustomerList;
	}
	

	public void FindList(CustomerConditionModel condition) {
		setAllCustomerList(customerInfoModelDAO.FindList(condition));
	}

	public Integer AddProgram(CustomerConditionModel condition) {
		return customerInfoModelDAO.AddProgram(condition);
	}

	public Integer CustomerCheck(CustomerConditionModel condition) {
		return customerInfoModelDAO.CustomerCheck(condition);
	}

	public void CustomerId(CustomerConditionModel condition) {
		setAllCustomerList(customerInfoModelDAO.CustomerId(condition));
	}

	public void EditCustomer(CustomerConditionModel condition) {
		setAllCustomerList(customerInfoModelDAO.EditCustomer(condition));
	}

	public Integer UpdateCustomer(CustomerConditionModel condition) {
		return customerInfoModelDAO.UpdateCustomer(condition);
	}

	public Integer DeleteCustomer(CustomerConditionModel condition) {
		return customerInfoModelDAO.DeleteCustomer(condition);
	}

	
}