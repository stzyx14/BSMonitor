package gmcc.bsmonitor.dao.impl;

import gmcc.bsmonitor.model.BaseStationInfo;
import gmcc.bsmonitor.model.BaseStationWarning;
import gmcc.bsmonitor.model.BsInfoAndWarning;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

@Repository(value="bsInfoAndWarningDaoImpl")
public class BsInfoAndWarningDaoImpl {
	
	@Resource
	private BaseStationInfoDaoImpl baseStationInfoDaoImpl;
	@Resource
	private BaseStationWarningDaoImpl baseStationWarningDaoImpl;
	
	public List<BsInfoAndWarning> getCurrentWarning(){
		List<BsInfoAndWarning> list = new ArrayList<BsInfoAndWarning>();
		List<BaseStationWarning> bsWarningList = baseStationWarningDaoImpl.getCurrentWarning(15000);
		if(bsWarningList != null){
			for (Iterator iterator = bsWarningList.iterator(); iterator.hasNext();) {
				BaseStationWarning baseStationWarning = (BaseStationWarning) iterator.next();
				BaseStationInfo baseStationInfo = baseStationInfoDaoImpl.getBaseStationInfo(baseStationWarning.getBtsId());
				BsInfoAndWarning bsInfoAndWarning = setBsInfoAndWarning(baseStationInfo, baseStationWarning);
				list.add(bsInfoAndWarning);
			}
		}
		return list;
	}
	
	public List<BsInfoAndWarning> getAll(){
		List<BsInfoAndWarning> list = new ArrayList<BsInfoAndWarning>();
		List<BaseStationInfo> bsInfoList = baseStationInfoDaoImpl.getAll();
		for (Iterator iterator = bsInfoList.iterator(); iterator.hasNext();) {
			BaseStationInfo baseStationInfo = (BaseStationInfo) iterator.next();
			BsInfoAndWarning bsInfoAndWarning = setBsInfoAndWarning(baseStationInfo, null);
			list.add(bsInfoAndWarning);
		}
		List<BaseStationWarning> bsWarningList = baseStationWarningDaoImpl.getCurrentWarning(15000);
		for (Iterator iterator = bsWarningList.iterator(); iterator.hasNext();) {
			BaseStationWarning baseStationWarning = (BaseStationWarning) iterator.next();
			int btsId = baseStationWarning.getBtsId();
			for (Iterator iterator2 = list.iterator(); iterator2.hasNext();) {
				BsInfoAndWarning bsInfoAndWarning = (BsInfoAndWarning) iterator2.next();
				if(bsInfoAndWarning.getBtsId() == btsId){
					bsInfoAndWarning.setCity(baseStationWarning.getCity());
					bsInfoAndWarning.setWarningTitle(baseStationWarning.getWarningTitle());
					bsInfoAndWarning.setWarningFactoryId(baseStationWarning.getWarningFactoryId());
					bsInfoAndWarning.setWarningFactoryLevel(baseStationWarning.getWarningFactoryLevel());
					bsInfoAndWarning.setWarningDeviceType(baseStationWarning.getWarningDeviceType());
					bsInfoAndWarning.setWarningHappenTime(baseStationWarning.getWarningHappenTime());
					bsInfoAndWarning.setWarningClearTime(baseStationWarning.getWarningClearTime());
					bsInfoAndWarning.setWarningNetAdminId(baseStationWarning.getWarningNetAdminId());
					bsInfoAndWarning.setWarningNetAdminLevel(baseStationWarning.getWarningNetAdminLevel());
				}
			}
		}
		return list;
	}
	public BaseStationInfoDaoImpl getBaseStationInfoDaoImpl() {
		return baseStationInfoDaoImpl;
	}
	public void setBaseStationInfoDaoImpl(
			BaseStationInfoDaoImpl baseStationInfoDaoImpl) {
		this.baseStationInfoDaoImpl = baseStationInfoDaoImpl;
	}
	public BaseStationWarningDaoImpl getBaseStationWarningDaoImpl() {
		return baseStationWarningDaoImpl;
	}
	public void setBaseStationWarningDaoImpl(
			BaseStationWarningDaoImpl baseStationWarningDaoImpl) {
		this.baseStationWarningDaoImpl = baseStationWarningDaoImpl;
	}
	
	public BsInfoAndWarning setBsInfoAndWarning(BaseStationInfo baseStationInfo, BaseStationWarning baseStationWarning){
		if(baseStationInfo == null)
			return null;
		BsInfoAndWarning bsInfoAndWarning = new BsInfoAndWarning();
		bsInfoAndWarning.setBtsId(baseStationInfo.getBtsId());
		bsInfoAndWarning.setBtsName(baseStationInfo.getBtsName());
		bsInfoAndWarning.setDeviceType(baseStationInfo.getDeviceType());
		bsInfoAndWarning.setFactoryId(baseStationInfo.getFactoryId());
		bsInfoAndWarning.setFactoryName(baseStationInfo.getFactoryName());
		bsInfoAndWarning.setLatitude(baseStationInfo.getLatitude());
		bsInfoAndWarning.setLongitude(baseStationInfo.getLongitude());
		if(baseStationWarning != null){
			bsInfoAndWarning.setCity(baseStationWarning.getCity());
			bsInfoAndWarning.setWarningTitle(baseStationWarning.getWarningTitle());
			bsInfoAndWarning.setWarningFactoryId(baseStationWarning.getWarningFactoryId());
			bsInfoAndWarning.setWarningFactoryLevel(baseStationWarning.getWarningFactoryLevel());
			bsInfoAndWarning.setWarningDeviceType(baseStationWarning.getWarningDeviceType());
			bsInfoAndWarning.setWarningHappenTime(baseStationWarning.getWarningHappenTime());
			bsInfoAndWarning.setWarningClearTime(baseStationWarning.getWarningClearTime());
			bsInfoAndWarning.setWarningNetAdminId(baseStationWarning.getWarningNetAdminId());
			bsInfoAndWarning.setWarningNetAdminLevel(baseStationWarning.getWarningNetAdminLevel());
		}
		return bsInfoAndWarning;
	}
}
