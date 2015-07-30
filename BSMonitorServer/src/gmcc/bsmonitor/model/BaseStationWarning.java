package gmcc.bsmonitor.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.JsonObject;

@Entity
@Table(name="tb_bswarning")
public class BaseStationWarning {

	@Id
	private int id;
	
	@Column(name="bts_id")
	private int btsId; //网元id
	
	private String city; //告警城市
	
	@Column(name="warning_device_type")
	private String warningDeviceType; //告警对象设备类型
	
	@Column(name="warning_factory_level")
	private String warningFactoryLevel; //厂家告警级别
	
	@Column(name="warning_title")
	private String warningTitle; //告警标题
	
	@Column(name="warning_netadmin_level")
	private String warningNetAdminLevel; //网管告警级别
	
	@Column(name="warning_happen_time")
	private Date warningHappenTime; //告警发生时间
	
	@Column(name="warning_clear_time")
	private Date warningClearTime; //告警清除时间
	
	@Column(name="warning_factory_id")
	private String warningFactoryId; //厂家告警ID
	
	@Column(name="warning_netadmin_id")
	private String warningNetAdminId; //网警告警ID
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBtsId() {
		return btsId;
	}
	public void setBtsId(int btsId) {
		this.btsId = btsId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
		json.addProperty("city", city);
		json.addProperty("warningDeviceType", warningDeviceType);
		json.addProperty("warningFactoryLevel", warningFactoryLevel);
		json.addProperty("warningTitle", warningTitle);
		json.addProperty("warningNetAdminLevel", warningNetAdminLevel);
		json.addProperty("warningHappenTime", warningHappenTime.toString());
		json.addProperty("warningClearTime", warningClearTime.toString());
		json.addProperty("warningFactoryId", warningFactoryId);
		json.addProperty("warningNetAdminId", warningNetAdminId);
		return json;
	}
	
}
