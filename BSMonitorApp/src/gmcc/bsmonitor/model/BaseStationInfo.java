package gmcc.bsmonitor.model;

public class BaseStationInfo {
	private String id; //基站id
	private String btsName; //网元名称
	private String productFactory; //设备厂家
	private String province; //所在省份
	private String city; //所在城市
	private String town; //所在区县
	private String bureau; //所在局
	private String machineRoom; //所在机房
	private double longitude; //经度
	private double latitude; //纬度
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBtsName() {
		return btsName;
	}
	public void setBtsName(String btsName) {
		this.btsName = btsName;
	}
	public String getProductFactory() {
		return productFactory;
	}
	public void setProductFactory(String productFactory) {
		this.productFactory = productFactory;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getBureau() {
		return bureau;
	}
	public void setBureau(String bureau) {
		this.bureau = bureau;
	}
	public String getMachineRoom() {
		return machineRoom;
	}
	public void setMachineRoom(String machineRoom) {
		this.machineRoom = machineRoom;
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
