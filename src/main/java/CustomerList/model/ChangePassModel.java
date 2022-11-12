package CustomerList.model;

public class ChangePassModel {
	
	private String UserId;
	private String MasterKey;
	private String NewPassword;
	
	public ChangePassModel() {
		
	}
	
	public ChangePassModel(
			String UesrId,
			String MasterKey,
			String NewPassword
	) {
			this.UserId = UesrId;
			this.MasterKey = MasterKey;
			this.NewPassword = NewPassword;
	}
	
	public String getUserId() {
		return UserId;
	}

	public String getMasterKey() {
		return MasterKey;
	}

	public String getNewPassword() {
		return NewPassword;
	}

}
