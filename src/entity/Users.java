package entity;

public class Users {
	private int id;
	private String name;
	private String password;
	private String tel;
	private String email;
	private int user_status;	//登录状态
	private int permission_code;	//权限级别
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUser_status() {
		return user_status;
	}
	public void setUser_status(int user_status) {
		this.user_status = user_status;
	}
	public int getPermission_code() {
		return permission_code;
	}
	public void setPermission_code(int permission_code) {
		this.permission_code = permission_code;
	}
	
}
