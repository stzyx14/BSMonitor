package gmcc.bsmonitor.dao.impl;

import gmcc.bsmonitor.dao.BaseStationInfoDao;
import gmcc.bsmonitor.model.BaseStationInfo;
import gmcc.bsmonitor.utils.HibernateUtil;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Implement of BaseStationInfoDao Interface
 * @author zyx
 */
@Repository(value="baseStationInfoDaoImpl")
public class BaseStationInfoDaoImpl implements BaseStationInfoDao {

	@Resource
	private HibernateUtil hibernateUtil;
	
	public HibernateUtil getHibernateUtil() {
		return hibernateUtil;
	}

	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	@Override
	public List<BaseStationInfo> getAll(){
		/*String sql = "select * from tb_bsinfo";
		List<BaseStationInfo> list = new ArrayList<BaseStationInfo>();
		try {
			ResultSet rs = DBUtil.excuteQuery(sql);
			while(rs.next()){
				BaseStationInfo baseStationInfo = fillBSInfo(rs);
				list.add(baseStationInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;*/
		String hql = "from BaseStationInfo";
		return hibernateUtil.exeQuery(hql);
	}
	
	@Override
	public BaseStationInfo getBaseStationInfo(int id){
		/*String sql = "select * from tb_bsinfo where bts_id=?";
		BaseStationInfo baseStationInfo = null;
		try {
			ResultSet rs = DBUtil.excuteQuery(sql, id);
			if(rs.next()){
				baseStationInfo = fillBSInfo(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return baseStationInfo;*/
		String hql = "from BaseStationInfo where bts_id="+id;
		return (BaseStationInfo)hibernateUtil.exeQuery(hql).get(0);
	}
	
	/*private BaseStationInfo fillBSInfo(ResultSet rs) throws SQLException{
		BaseStationInfo baseStationInfo = new BaseStationInfo();
		baseStationInfo.setBtsId(rs.getInt("bts_id"));
		baseStationInfo.setBtsName(rs.getString("bts_name"));
		baseStationInfo.setLongitude(rs.getDouble("longitude"));
		baseStationInfo.setLatitude(rs.getDouble("latitude"));
		return baseStationInfo;
	}*/
}
