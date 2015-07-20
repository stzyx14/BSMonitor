package gmcc.bsmonitor.dao;

import gmcc.bsmonitor.model.BaseStationInfo;

import java.util.List;

/**
 * @author zyx
 */
public interface BaseStationInfoDao {

	/**
	 * @return all base stations
	 */
	public abstract List<BaseStationInfo> getAll();

	/**
	 * @param id the key of base station
	 * @return
	 */
	public abstract BaseStationInfo getBaseStationInfo(String id);

}