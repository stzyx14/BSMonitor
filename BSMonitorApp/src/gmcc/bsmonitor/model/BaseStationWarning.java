package gmcc.bsmonitor.model;

import java.sql.Date;

public class BaseStationWarning {

	private String id; //��վid
	private Date warningHappenTime; //�澯����ʱ��
	private Date warningFindTime; //�澯����ʱ��
	private String warningTitle; //�澯����
	private String warningLevel; //�澯����
	
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
