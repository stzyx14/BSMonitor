package gmcc.bsmonitor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.JsonObject;

@Entity
@Table(name="tb_user")
public class User {
	
	@Id
	private int id;
	
	@Column(name="username")
	private String userName;
	
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public JsonObject toJson(){
		JsonObject json = new JsonObject();
		json.addProperty("id", id);
		json.addProperty("userName", userName);
		json.addProperty("password", password);
		return json;
	}
	
}
