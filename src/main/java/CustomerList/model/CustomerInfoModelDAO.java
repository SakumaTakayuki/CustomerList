package CustomerList.model;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CustomerInfoModelDAO extends JdbcDaoSupport {
	
	@Autowired
	public CustomerInfoModelDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	//ログイン
	public Integer Login(LoginModel loginModel) {
		String sql = "select count(*) from user_list where 1 = 1 ";
		sql += "and user_id = '" + loginModel.getUserId() + "' "; 
		sql += "and password = '" + loginModel.getPassword() + "'";
		try {
			return getJdbcTemplate().queryForObject(sql, new Object[] { }, Integer.class);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	//パスワード変更本人確認
	public Integer CheckPass(ChangePassModel changePassModel) {
		String sql = "select count(*) from user_list where 1 = 1 ";
		sql += "and user_id = '" + changePassModel.getUserId() + "' "; 
		sql += "and masterkey = '" + changePassModel.getMasterKey() + "'";
		try {
			return getJdbcTemplate().queryForObject(sql, new Object[] { }, Integer.class);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	//パスワード変更
	public Integer ChangePass(ChangePassModel changePassModel) {
		try {
			getJdbcTemplate().update("update user_list set password = (?) where user_id = (?)",
					changePassModel.getNewPassword(), changePassModel.getUserId());
			return 1;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	//一覧表示
	public List<CustomerInfoModel> FindList(CustomerConditionModel condition) {
		String sql = CustomerInfoModelMapper.BASE_SQL + "where 1=1 ";
		//お客様番号
		if (condition.getCustomerId() != "") {
			sql += "and customer_id = '" + condition.getCustomerId() + "' ";
		}
		//名前
		if (condition.getName() != "") {
			sql += "and name like '%" + condition.getName() + "%' ";
		}
		//名前
		if (condition.getTel() != "") {
			sql += "and tel = '" + condition.getTel() + "' ";
		}
		//利用期間
		if (condition.getDuration() != 0) {
			if (condition.getDuration() == 1) {
				sql += "and duration = '" + condition.getDuration() + "' ";
			}
			if (condition.getDuration() == 2) {
				sql += "and duration between '1' and '" + condition.getDuration() + "' ";
			}
			if (condition.getDuration() == 3) {
				sql += "and duration between '1' and '" + condition.getDuration() + "' ";
			}
			if (condition.getDuration() == 4) {
				sql += "and duration between '1' and '" + condition.getDuration() + "' ";
			}
			if (condition.getDuration() == 5) {
				sql += "and duration = '" + condition.getDuration() + "' ";
			}
			if (condition.getDuration() == 0) {
				sql += "and duration = '" + condition.getDuration() + "' ";
			}
		}
		//機種
		if (condition.getType() != 0) {
			sql += "and Type = '" + condition.getType() + "' ";
		}
		//インターネット
		if (condition.getNet() != 0) {
			sql += "and net = '" + condition.getNet() + "' ";
		}
		
		CustomerInfoModelMapper mapper = new CustomerInfoModelMapper();
		try {
			List<CustomerInfoModel> list = this.getJdbcTemplate().query(sql, mapper);
			return list;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	//登録履歴確認
	public Integer CustomerCheck(CustomerConditionModel condition) {
		String sql = "select count(*) from customer_list where 1 = 1 ";
		sql += "and name = '" + condition.getName() + "' "; 
		sql += "and tel = '" + condition.getTel() + "';";
		try {
			return getJdbcTemplate().queryForObject(sql, new Object[] { }, Integer.class);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	//新規登録
	public Integer AddProgram(CustomerConditionModel condition) {
		try {
			getJdbcTemplate().update("insert into customer_list (name, tel, duration, type, net, memo) "
					+ "values ((?), (?), (?) , (?), (?), (?));",
					condition.getName(), condition.getTel(), condition.getDuration(), 
					condition.getType(), condition.getNet(), condition.getMemo());
			return 1;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	//新規ID検索
	public List<CustomerInfoModel> CustomerId(CustomerConditionModel condition) {
		String sql = CustomerInfoModelMapper.BASE_SQL + "where 1=1 ";
		sql += "and name = '" + condition.getName() + "' ";
		sql += "and tel = '" + condition.getTel() + "';";
		CustomerInfoModelMapper mapper = new CustomerInfoModelMapper();
		try {
			List<CustomerInfoModel> list = this.getJdbcTemplate().query(sql, mapper);
			return list;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	//編集画面表示
	public List<CustomerInfoModel> EditCustomer(CustomerConditionModel condition) {
		String sql = CustomerInfoModelMapper.BASE_SQL + "where 1=1 ";
		sql += "and customer_id = " + condition.getCustomerId() + ";";
		CustomerInfoModelMapper mapper = new CustomerInfoModelMapper();
		try {
			List<CustomerInfoModel> list = this.getJdbcTemplate().query(sql, mapper);
			return list;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	//更新
	public Integer UpdateCustomer(CustomerConditionModel condition) {
		try {
			getJdbcTemplate().update("update customer_list "
					+ "set name = (?), tel = (?), duration = (?), type = (?), net = (?), memo = (?) "
					+ "where customer_id = (?);",
					condition.getName(), condition.getTel(), condition.getDuration(), condition.getType(), 
					condition.getNet(), condition.getMemo(), condition.getCustomerId());					
			return 1;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	//削除
	public Integer DeleteCustomer(CustomerConditionModel condition) {
		try {
			getJdbcTemplate().update("delete from customer_list "
					+ "where customer_id = (?);",condition.getCustomerId());
			return 1;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
