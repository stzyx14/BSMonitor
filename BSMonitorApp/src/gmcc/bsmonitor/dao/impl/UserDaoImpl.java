package gmcc.bsmonitor.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import gmcc.bsmonitor.dao.UserDao;
import gmcc.bsmonitor.model.User;
import gmcc.bsmonitor.utils.DBUtil;

/**
 * Implement of UserDao Interface
 * @author zyx
 */
public class UserDaoImpl implements UserDao {

	/* (non-Javadoc)
	 * @see gmcc.bsmonitor.dao.impl.UserDao#getUser(java.lang.String)
	 */
	@Override
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
