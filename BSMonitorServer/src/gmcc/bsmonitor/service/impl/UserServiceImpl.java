package gmcc.bsmonitor.service.impl;

import gmcc.bsmonitor.dao.UserDao;
import gmcc.bsmonitor.model.User;
import gmcc.bsmonitor.service.UserService;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service(value="userServiceImpl")
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDaoImpl;
	
	public UserDao getUserDaoImpl() {
		return userDaoImpl;
	}

	public void setUserDaoImpl(UserDao userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}
	
	@Override
	public boolean login(String userName, String password){
		User user = userDaoImpl.getUser(userName);
		if(user.getPassword().equals(password))
			return true;
		else
			return false;
	}
}
