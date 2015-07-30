package gmcc.bsmonitor.web.controller;

import gmcc.bsmonitor.model.BsInfoAndWarning;
import gmcc.bsmonitor.service.BaseStationService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.JsonArray;

@Controller
@RequestMapping("/bs")
public class BaseStationController {

	@Resource
	private BaseStationService baseStationServiceImpl;

	@RequestMapping("/test")
	public void test(HttpServletRequest request, PrintWriter writer){
		
	}
	
	@RequestMapping("/getAll")
	public void getAll(HttpServletRequest request, HttpServletResponse response){
		List<BsInfoAndWarning> list = baseStationServiceImpl.getAllBsInfoAndWarning();
		JsonArray jsonArr = new JsonArray();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			BsInfoAndWarning bsInfoAndWarning = (BsInfoAndWarning) iterator.next();
			jsonArr.add(bsInfoAndWarning.toJson());
		}
		System.out.println(jsonArr.toString());
		response.setCharacterEncoding("utf-8");        
	    response.setContentType("text/html; charset=utf-8");   
	    PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.write(jsonArr.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public BaseStationService getBaseStationServiceImpl() {
		return baseStationServiceImpl;
	}

	public void setBaseStationServiceImpl(BaseStationService baseStationServiceImpl) {
		this.baseStationServiceImpl = baseStationServiceImpl;
	}


}
