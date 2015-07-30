package gmcc.bsmonitor.service;

import gmcc.bsmonitor.model.BsInfoAndWarning;

import java.util.List;

public interface BaseStationService {

	public abstract List<BsInfoAndWarning> getAllBsInfoAndWarning();

	public abstract List<BsInfoAndWarning> getCurrentBsInfoAndWarning();

}