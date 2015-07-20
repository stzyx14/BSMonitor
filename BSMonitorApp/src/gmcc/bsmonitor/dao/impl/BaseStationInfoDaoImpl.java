package gmcc.bsmonitor.dao.impl;

import gmcc.bsmonitor.dao.BaseStationInfoDao;
import gmcc.bsmonitor.model.BaseStationInfo;
import gmcc.bsmonitor.utils.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implement of BaseStationInfoDao Interface
 * @author zyx
 */
public class BaseStationInfoDaoImpl implements BaseStationInfoDao {

	/* (non-Javadoc)
	 * @see gmcc.bsmonitor.dao.impl.BaseStationInfoDao#getAll()
	 */
	@Override
	public List<BaseStationInfo> getAll(){
		String sql = "select * from tb_bsinfo";
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
		return list;
	}
	
	/* (non-Javadoc)
	 * @see gmcc.bsmonitor.dao.impl.BaseStationInfoDao#getBaseStationInfo(int)
	 */
	@Override
	public BaseStationInfo getBaseStationInfo(String id){
		String sql = "select * from tb_bsinfo where id=?";
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
		return baseStationInfo;
	}
	
	private BaseStationInfo fillBSInfo(ResultSet rs) throws SQLException{
		BaseStationInfo baseStationInfo = new BaseStationInfo();
		baseStationInfo.setId(rs.getString("id"));
		baseStationInfo.setBtsName(rs.getString("bts_name"));
		baseStationInfo.setProductFactory(rs.getString("product_factory"));
		baseStationInfo.setProvince(rs.getString("province"));
		baseStationInfo.setCity(rs.getString("city"));
		baseStationInfo.setTown(rs.getString("town"));
		baseStationInfo.setBureau(rs.getString("bureau"));
		baseStationInfo.setMachineRoom(rs.getString("machine_room"));
		baseStationInfo.setLongitude(rs.getDouble("longitude"));
		baseStationInfo.setLatitude(rs.getDouble("latitude"));
		return baseStationInfo;
	}
}
