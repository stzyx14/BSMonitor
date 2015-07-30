package gmcc.bsmonitor.service.impl;

import gmcc.bsmonitor.dao.impl.BsInfoAndWarningDaoImpl;
import gmcc.bsmonitor.model.BsInfoAndWarning;
import gmcc.bsmonitor.service.BaseStationService;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service(value="baseStationServiceImpl")
public class BaseStationServiceImpl implements BaseStationService {

	@Resource
	private BsInfoAndWarningDaoImpl bsInfoAndWarningDaoImpl;
	
	public BsInfoAndWarningDaoImpl getBsInfoAndWarningDaoImpl() {
		return bsInfoAndWarningDaoImpl;
	}

	public void setBsInfoAndWarningDaoImpl(
			BsInfoAndWarningDaoImpl bsInfoAndWarningDaoImpl) {
		this.bsInfoAndWarningDaoImpl = bsInfoAndWarningDaoImpl;
	}
	
	@Override
	public List<BsInfoAndWarning> getAllBsInfoAndWarning(){
		return bsInfoAndWarningDaoImpl.getAll();
	}

	@Override
	public List<BsInfoAndWarning> getCurrentBsInfoAndWarning(){
		return bsInfoAndWarningDaoImpl.getCurrentWarning();
	}
}
