package CustomerList.model;

public class LoginModel {
	private String UserId;
	private String Password;
	
	public LoginModel() {
		
	}
	
	public LoginModel(
			String UserId,
			String Password
	) {
			this.UserId = UserId;
			this.Password = Password;
	}
		
	public String getUserId() {
		return UserId;
	}
	
	public String getPassword() {
		return Password;
	}

}
