package gmcc.bsmonitor.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import gmcc.bsmonitor.dao.UserDao;
import gmcc.bsmonitor.model.User;
import gmcc.bsmonitor.utils.DBUtil;
import gmcc.bsmonitor.utils.HibernateUtil;

/**
 * Implement of UserDao Interface
 * @author zyx
 */
@Repository(value="userDaoImpl")
public class UserDaoImpl implements UserDao {

	@Resource
	private HibernateUtil hibernateUtil;
	
	public HibernateUtil getHibernateUtil() {
		return hibernateUtil;
	}

	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}
	
	public User getUser(String userName){
		String sql = "select * from tb_user where username=?";
		User user = null;
		try {
			ResultSet rs = DBUtil.excuteQuery(sql, userName);
			if(rs.next()){
				user = new User();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}
