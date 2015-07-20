package gmcc.bsmonitor.model;

import java.sql.Date;

public class BaseStationWarning {

	private String id; //基站id
	private Date warningHappenTime; //告警发生时间
	private Date warningFindTime; //告警发现时间
	private String warningTitle; //告警标题
	private String warningLevel; //告警级别
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getWarningHappenTime() {
		return warningHappenTime;
	}
	public void setWarningHappenTime(Date warningHappenTime) {
		this.warningHappenTime = warningHappenTime;
	}
	public Date getWarningFindTime() {
		return warningFindTime;
	}
	public void setWarningFindTime(Date warningFindTime) {
		this.warningFindTime = warningFindTime;
	}
	public String getWarningTitle() {
		return warningTitle;
	}
	public void setWarningTitle(String warningTitle) {
		this.warningTitle = warningTitle;
	}
	public String getWarningLevel() {
		return warningLevel;
	}
	public void setWarningLevel(String warningLevel) {
		this.warningLevel = warningLevel;
	}

}
