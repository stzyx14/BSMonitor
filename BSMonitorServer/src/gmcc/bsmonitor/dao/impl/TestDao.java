package gmcc.bsmonitor.dao.impl;

import gmcc.bsmonitor.dao.BaseStationInfoDao;
import gmcc.bsmonitor.dao.BaseStationWarningDao;
import gmcc.bsmonitor.model.BaseStationWarning;
import gmcc.bsmonitor.model.BsInfoAndWarning;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;


public class TestDao {

	@Test
	public void testBaseStationInfoDao(){
		BaseStationInfoDao baseStationInfoDao = new BaseStationInfoDaoImpl();
		//BaseStationInfo baseStationInfo = baseStationInfoDao.getBaseStationInfo("GD0003");
		//System.out.println(baseStationInfo.getBtsName());
		/*List<BaseStationInfo> list = baseStationInfoDao.getAll();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			BaseStationInfo baseStationInfo = (BaseStationInfo) iterator.next();
			System.out.println(baseStationInfo.getBtsName());
		}*/
	}
	@Test
	public void testBaseStationWarningDao(){
		BaseStationWarningDao baseStationWarningDao = new BaseStationWarningDaoImpl();
		List<BaseStationWarning> list = baseStationWarningDao.getCurrentWarning(10000);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			BaseStationWarning baseStationWarning = (BaseStationWarning) iterator
					.next();
			//System.out.println(baseStationWarning.getWarningTitle());
		}
	}
	
	@Test
	public void testBsInfoAndWarningDaoImpl(){
		BsInfoAndWarningDaoImpl bsInfoAndWarningDaoImpl = new BsInfoAndWarningDaoImpl();
		List<BsInfoAndWarning> list = bsInfoAndWarningDaoImpl.getAll();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			BsInfoAndWarning bsInfoAndWarning = (BsInfoAndWarning) iterator
					.next();
			System.out.println(bsInfoAndWarning.getWarningTitle());
		}
	}
}
