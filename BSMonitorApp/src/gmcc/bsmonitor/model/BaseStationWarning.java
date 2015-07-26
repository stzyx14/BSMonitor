package gmcc.bsmonitor.model;

import java.sql.Date;

public class BaseStationWarning {

	private int btsId; //网元id
	private String btsName; //网元名称
	private String city; //告警城市
	private String deviceType;  //设备类型
	private String warningDeviceType; //告警对象设备类型
	private String warningFactoryLevel; //厂家告警级别
	private int factoryId; //厂家原始ID
	private String factoryName; //厂家名称
	private String warningTitle; //告警标题
	private String warningNetAdminLevel; //网管告警级别
	private Date warningHappenTime; //告警发生时间
	private Date warningClearTime; //告警清除时间
	private int warningFactoryId; //厂家告警ID
	private int warningNetAdminId; //网警告警ID
	
	public int getBtsId() {
		return btsId;
	}
	public void setBtsId(int btsId) {
		this.btsId = btsId;
	}
	public String getBtsName() {
		return btsName;
	}
	public void setBtsName(String btsName) {
		this.btsName = btsName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public String getWarningDeviceType() {
		return warningDeviceType;
	}
	public void setWarningDeviceType(String warningDeviceType) {
		this.warningDeviceType = warningDeviceType;
	}
	public String getWarningFactoryLevel() {
		return warningFactoryLevel;
	}
	public void setWarningFactoryLevel(String warningFactoryLevel) {
		this.warningFactoryLevel = warningFactoryLevel;
	}
	public int getFactoryId() {
		return factoryId;
	}
	public void setFactoryId(int factoryId) {
		this.factoryId = factoryId;
	}
	public String getFactoryName() {
		return factoryName;
	}
	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}
	public String getWarningTitle() {
		return warningTitle;
	}
	public void setWarningTitle(String warningTitle) {
		this.warningTitle = warningTitle;
	}
	public String getWarningNetAdminLevel() {
		return warningNetAdminLevel;
	}
	public void setWarningNetAdminLevel(String warningNetAdminLevel) {
		this.warningNetAdminLevel = warningNetAdminLevel;
	}
	public Date getWarningHappenTime() {
		return warningHappenTime;
	}
	public void setWarningHappenTime(Date warningHappenTime) {
		this.warningHappenTime = warningHappenTime;
	}
	public Date getWarningClearTime() {
		return warningClearTime;
	}
	public void setWarningClearTime(Date warningClearTime) {
		this.warningClearTime = warningClearTime;
	}
	public int getWarningFactoryId() {
		return warningFactoryId;
	}
	public void setWarningFactoryId(int warningFactoryId) {
		this.warningFactoryId = warningFactoryId;
	}
	public int getWarningNetAdminId() {
		return warningNetAdminId;
	}
	public void setWarningNetAdminId(int warningNetAdminId) {
		this.warningNetAdminId = warningNetAdminId;
	}
	
	
}
