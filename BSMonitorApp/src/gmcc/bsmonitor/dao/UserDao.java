package gmcc.bsmonitor.dao;

import gmcc.bsmonitor.model.User;

/**
 * @author zyx
 */
public interface UserDao {

	/**
	 * @param userName
	 * @return user
	 */
	public abstract User getUser(String userName);

}