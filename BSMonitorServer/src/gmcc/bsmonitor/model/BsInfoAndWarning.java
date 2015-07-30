package gmcc.bsmonitor.model;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.persistence.Column;

import com.google.gson.JsonObject;

public class BsInfoAndWarning {

	private int btsId; //网元ID
	private String btsName; //网元名称
	private double longitude; //经度
	private double latitude; //纬度
	private String city; //告警城市
	private String deviceType;  //设备类型
	private String warningDeviceType; //告警对象设备类型
	private String warningFactoryLevel; //厂家告警级别
	private String factoryId; //厂家原始ID
	private String factoryName; //厂家名称
	private String warningTitle; //告警标题
	private String warningNetAdminLevel; //网管告警级别
	private Date warningHappenTime; //告警发生时间
	private Date warningClearTime; //告警清除时间
	private String warningFactoryId; //厂家告警ID
	private String warningNetAdminId; //网警告警ID
	
	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
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
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
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
	public String getFactoryId() {
		return factoryId;
	}
	public void setFactoryId(String factoryId) {
		this.factoryId = factoryId;
	}
	public String getWarningFactoryId() {
		return warningFactoryId;
	}
	public void setWarningFactoryId(String warningFactoryId) {
		this.warningFactoryId = warningFactoryId;
	}
	public String getWarningNetAdminId() {
		return warningNetAdminId;
	}
	public void setWarningNetAdminId(String warningNetAdminId) {
		this.warningNetAdminId = warningNetAdminId;
	}

	public JsonObject toJson(){
		JsonObject json = new JsonObject();
		json.addProperty("btsId", btsId);
		json.addProperty("btsName", btsName);
		json.addProperty("longitude", longitude);
		json.addProperty("latitude", latitude);
		json.addProperty("deviceType", deviceType);
		json.addProperty("factoryId", factoryId);
		json.addProperty("factoryName", factoryName);
		json.addProperty("city", city);
		json.addProperty("warningDeviceType", ""+warningDeviceType);
		json.addProperty("warningFactoryLevel", ""+warningFactoryLevel);
		json.addProperty("warningTitle", ""+warningTitle);
		json.addProperty("warningNetAdminLevel", ""+warningNetAdminLevel);
		if(warningHappenTime != null)
			json.addProperty("warningHappenTime", format.format(warningHappenTime));
		else
			json.addProperty("warningHappenTime", "null");
		if(warningClearTime != null)
			json.addProperty("warningClearTime", format.format(warningClearTime));
		else
			json.addProperty("warningClearTime", "null");
		json.addProperty("warningFactoryId", ""+warningFactoryId);
		json.addProperty("warningNetAdminId", ""+warningNetAdminId);
		return json;
	}
	
}
