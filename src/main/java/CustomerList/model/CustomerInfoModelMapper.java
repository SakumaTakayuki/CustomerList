package CustomerList.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerInfoModelMapper implements RowMapper<CustomerInfoModel> {
	
	public static final String BASE_SQL = 
			"select *, date_format(insert_time, '%Y/%m/%d %k:%i'), "
			+ "date_format(update_time, '%Y/%m/%d %k:%i') "
			+ "from customer_list ";
	
	@Override
	public CustomerInfoModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		String CustomerId = rs.getString("customer_id");
		String Name = rs.getString("name");
		String Tel = rs.getString("tel");
		Integer Duration = rs.getInt("duration");
		Integer Type = rs.getInt("type");
		Integer Net = rs.getInt("net");
		String Memo = rs.getString("memo");
		String AddDay = rs.getString("date_format(insert_time, '%Y/%m/%d %k:%i')");
		String UpdateDay = rs.getString("date_format(update_time, '%Y/%m/%d %k:%i')");
		
		return new CustomerInfoModel(
				CustomerId,
				Name,
				Tel,
				Duration,
				Type,
				Net,
				Memo,
				AddDay,
				UpdateDay
		);
		
	}

}
