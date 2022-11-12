package CustomerList.model;

public class CustomerInfoModel {
	
	private String CustomerId;
	private String Name;
	private String Tel;
	private Integer Duration;
	private Integer Type;
	private Integer Net;
	private String Memo;
	private String AddDay;
	private String UpdateDay;
//	private Integer CustomerIdMax;
	
	public CustomerInfoModel() {
		
	}
	
	public CustomerInfoModel(
			String CustomerId,
			String Name,
			String Tel,
			Integer Duration,
			Integer Type,
			Integer Net,
			String Memo,
			String AddDay,
			String UpdateDay
	) {
		this.CustomerId = CustomerId;
		this.Name = Name;
		this.Tel = Tel;
		this.Duration = Duration;
		this.Type = Type;
		this.Net = Net;
		this.Memo = Memo;
		this.AddDay = AddDay;
		this.UpdateDay = UpdateDay;
//		this.CustomerIdMax = CustomerIdMax;
	}
	
	public String getCustomerId() {
		return CustomerId;
	}
	
	public String getName() {
		return Name;
	}

	public String getTel() {
		return Tel;
	}
	
	public Integer getDuration() {
		return Duration;
	}
	
	public Integer getType() {
		return Type;
	}
	
	public Integer getNet() {
		return Net;
	}
	
	public String getMemo() {
		return Memo;
	}
	
	public String getAddDay() {
		return AddDay;
	}
	
	public String getUpdateDay() {
		return UpdateDay;
	}
	
//	public Integer CustomerIdMax() {
//		return CustomerIdMax;
//	}

}
