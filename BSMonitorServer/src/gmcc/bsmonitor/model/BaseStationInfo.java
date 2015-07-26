package gmcc.bsmonitor.model;

public class BaseStationInfo {
	private String btsId; //网元id
	private String btsName; //网元名称
	private double longitude; //经度
	private double latitude; //纬度
	
	public String getBtsId() {
		return btsId;
	}
	public void setBtsId(String btsId) {
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

}
