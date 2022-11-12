package CustomerList.model;

public class CustomerConditionModel {

	private String CustomerId;
	private String Name;
	private String Tel;
	private Integer Duration;
	private Integer Type;
	private Integer Net;
	private String Memo;
	private String InsertTime;
	private String UpdateTime;
	
	public CustomerConditionModel() {
		
	}
	
	public CustomerConditionModel(
			String CustomerId,
			String Name,
			String Tel,
			Integer Duration,
			Integer Type,
			Integer Net,
			String Memo,
			String InsertTime,
			String UpdateTime
	) {
			this.CustomerId = CustomerId;
			this.Name = Name;
			this.Tel = Tel;
			this.Duration = Duration;
			this.Type = Type;
			this.Net = Net;
			this.Memo = Memo;
			this.InsertTime = InsertTime;
			this.UpdateTime = UpdateTime;
	}
	
	public CustomerConditionModel(String Name) {
			this.Name = Name;
	}

	public String getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(String CustomerId) {
		this.CustomerId = CustomerId;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	
	public String getTel() {
		return Tel;
	}
	public void setTel(String Tel) {
		this.Tel = Tel;
	}
	
	public Integer getDuration() {
		return Duration;
	}
	public void setDuration(Integer Duration) {
		this.Duration = Duration;
	}
	
	public Integer getType() {
		return Type;
	}
	public void setType(Integer Type) {
		this.Type = Type;
	}
	
	public Integer getNet() {
		return Net;
	}
	public void setNet(Integer Net) {
		this.Net = Net;
	}

	public String getMemo() {
		return Memo;
	}
	public void setMemo(String Memo) {
		this.Memo = Memo;
	}
	
	public String getInsertTime() {
		return InsertTime;
	}
	public void setInsertTime(String InsertTime) {
		this.InsertTime = InsertTime;
	}

	public String getUpdateTime() {
		return UpdateTime;
	}
	public void setUpdateTime(String UpdateTime) {
		this.UpdateTime = UpdateTime;
	}

}
