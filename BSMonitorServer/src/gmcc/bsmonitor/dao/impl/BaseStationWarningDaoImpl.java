package gmcc.bsmonitor.dao.impl;

import gmcc.bsmonitor.dao.BaseStationWarningDao;
import gmcc.bsmonitor.model.BaseStationWarning;
import gmcc.bsmonitor.utils.DBUtil;
import gmcc.bsmonitor.utils.HibernateUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

/**
 * Implement of BaseStationWarningDao Interface
 * @author zyx
 */
@Repository(value="baseStationWarningDaoImpl")
public class BaseStationWarningDaoImpl implements BaseStationWarningDao {

	private static Date startDate, initialDate;
	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	static{
		String dateStr = "2015-7-20 11:10:38";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			initialDate = format.parse(dateStr);
			startDate = format.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Resource
	private HibernateUtil hibernateUtil;
	
	public HibernateUtil getHibernateUtil() {
		return hibernateUtil;
	}

	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	@Override
	public List<BaseStationWarning> getBSHistoryWarning(int id){
		String hql = "from BaseStationWarning where bts_id="+id;
		return hibernateUtil.exeQuery(hql);
	}
	
	@Override
	public List<BaseStationWarning> getCurrentWarning(int queryPeriod){
		Date endDate = new Date();
		endDate.setTime(startDate.getTime() + queryPeriod);
		String endDateStr = format.format(endDate);
		String startDateStr = format.format(startDate);
		String hql = "from BaseStationWarning where warning_happen_time>='"+startDateStr+"'and warning_happen_time<'"+endDateStr+"'";
		List<BaseStationWarning> list = hibernateUtil.exeQuery(hql);
		if(list == null){
			startDate = new Date(initialDate.getTime());
			list = getCurrentWarning(queryPeriod);
		} else
			startDate = endDate;
		return list;
	}

}
