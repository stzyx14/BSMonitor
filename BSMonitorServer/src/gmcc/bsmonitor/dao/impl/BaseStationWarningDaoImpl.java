package gmcc.bsmonitor.dao.impl;

import gmcc.bsmonitor.dao.BaseStationWarningDao;
import gmcc.bsmonitor.model.BaseStationWarning;
import gmcc.bsmonitor.utils.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Implement of BaseStationWarningDao Interface
 * @author zyx
 */
public class BaseStationWarningDaoImpl implements BaseStationWarningDao {

	/* (non-Javadoc)
	 * @see gmcc.bsmonitor.dao.impl.BaseStationWarningDao#getBSHistoryWarning(java.lang.String)
	 */
	@Override
	public List<BaseStationWarning> getBSHistoryWarning(int id){
		String sql = "select * from tb_bswarning where bts_id='"+id+"'";
		List<BaseStationWarning> list = new ArrayList<BaseStationWarning>();
		try {
			ResultSet rs = DBUtil.excuteQuery(sql);
			while(rs.next()){
				BaseStationWarning bsw = fillBSWarning(rs);
				list.add(bsw);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/* (non-Javadoc)
	 * @see gmcc.bsmonitor.dao.impl.BaseStationWarningDao#getCurrentWarning(int)
	 */
	@Override
	public List<BaseStationWarning> getCurrentWarning(int queryPeriod){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		date.setTime(date.getTime() - queryPeriod);
		String dateStr = format.format(date);
		String sql = "select * from tb_bswarning where warning_happen_time>?";
		List<BaseStationWarning> list = new ArrayList<BaseStationWarning>();
		try {
			ResultSet rs = DBUtil.excuteQuery(sql, dateStr);
			while(rs.next()){
				BaseStationWarning bsw = fillBSWarning(rs);
				list.add(bsw);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	private BaseStationWarning fillBSWarning(ResultSet rs) throws SQLException{
		BaseStationWarning bsw = new BaseStationWarning();
		bsw.setBtsId(rs.getInt("bts_id"));
		bsw.setBtsName(rs.getString("bts_name"));
		bsw.setCity(rs.getString("city"));
		bsw.setDeviceType(rs.getString("device_type"));
		bsw.setWarningDeviceType(rs.getString("warning_device_type"));
		bsw.setWarningFactoryLevel(rs.getString("warning_factory_level"));
		bsw.setFactoryId(rs.getInt("factory_id"));
		bsw.setFactoryName(rs.getString("factory_name"));
		bsw.setWarningTitle(rs.getString("warning_title"));
		bsw.setWarningNetAdminLevel(rs.getString("warning_netadmin_level"));
		bsw.setWarningHappenTime(rs.getDate("warning_happen_time"));
		bsw.setWarningClearTime(rs.getDate("warning_clear_time"));
		bsw.setWarningFactoryId(rs.getInt("warning_factory_id"));
		bsw.setWarningNetAdminId(rs.getInt("warning_netadmin_id"));
		return bsw;
	}
}
