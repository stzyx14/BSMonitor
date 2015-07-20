package gmcc.bsmonitor.dao;


import gmcc.bsmonitor.model.BaseStationWarning;

import java.util.List;

/**
 * @author zyx
 */
public interface BaseStationWarningDao {

	/**
	 * @param id the key of base station
	 * @return all history warning record of this base station
	 */
	public abstract List<BaseStationWarning> getBSHistoryWarning(String id);

	/**
	 * @param queryPeriod the query period which is millisecond
	 * @return all warning record in this period
	 */
	public abstract List<BaseStationWarning> getCurrentWarning(int queryPeriod);

}