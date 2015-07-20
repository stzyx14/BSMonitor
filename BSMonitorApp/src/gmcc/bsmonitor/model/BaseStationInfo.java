package gmcc.bsmonitor.model;

public class BaseStationInfo {
	private String id; //��վid
	private String btsName; //��Ԫ����
	private String productFactory; //�豸����
	private String province; //����ʡ��
	private String city; //���ڳ���
	private String town; //��������
	private String bureau; //���ھ�
	private String machineRoom; //���ڻ���
	private double longitude; //����
	private double latitude; //γ��
	
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
