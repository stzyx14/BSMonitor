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
	public List<BaseStationWarning> getBSHistoryWarning(String id){
		String sql = "select * from tb_bswarning where id='"+id+"'";
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
		bsw.setId(rs.getString("id"));
		bsw.setWarningHappenTime(rs.getDate("warning_happen_time"));
		bsw.setWarningFindTime(rs.getDate("warning_find_time"));
		bsw.setWarningTitle(rs.getString("warning_title"));
		bsw.setWarningLevel(rs.getString("warning_level"));
		return bsw;
	}
}
