package gmcc.bsmonitor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.JsonObject;

@Entity
@Table(name="tb_bsinfo")
public class BaseStationInfo {
	
	@Id
	@Column(name="bts_id")
	private int btsId; //网元id
	
	@Column(name="bts_name")
	private String btsName; //网元名称
	
	private double longitude; //经度
	
	private double latitude; //纬度
	
	@Column(name="device_type")
	private String deviceType;  //设备类型
	
	@Column(name="factory_id")
	private String factoryId; //厂家原始ID
	
	@Column(name="factory_name")
	private String factoryName; //厂家名称
	
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
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public String getFactoryId() {
		return factoryId;
	}
	public void setFactoryId(String factoryId) {
		this.factoryId = factoryId;
	}
	public String getFactoryName() {
		return factoryName;
	}
	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}
	
	public JsonObject toJson(){
		JsonObject json = new JsonObject();
		json.addProperty("btsId", btsId);
		json.addProperty("btsNalatitudeme", btsName);
		json.addProperty("longitude", longitude);
		json.addProperty("latitude", latitude);
		json.addProperty("deviceType", deviceType);
		json.addProperty("factoryId", factoryId);
		json.addProperty("factoryName", factoryName);
		return json;
	}
}
