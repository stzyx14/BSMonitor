package gmcc.bsmonitor.web.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import gmcc.bsmonitor.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.JsonObject;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userServiceImpl;

	@RequestMapping("/login")
	public void login(HttpServletRequest request, PrintWriter writer){
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String result = null;
		if(userServiceImpl.login(userName, password))
			result = "success";
		else
			result = "fail";
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
	}
	
	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
	
	
}
