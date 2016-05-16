package cn.edu.fjnu.entity;

public class Manager {
	private String id;
	private String name;
	private String md5Password;
	private String	salt;
	private String permission;
	private int role;
	private int state;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMd5Password() {
		return md5Password;
	}
	public void setMd5Password(String md5Password) {
		this.md5Password = md5Password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Manager(String id, String name, String md5Password, String salt, String permission, int role, int state) {
		super();
		this.id = id;
		this.name = name;
		this.md5Password = md5Password;
		this.salt = salt;
		this.permission = permission;
		this.role = role;
		this.state = state;
	}
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", md5Password=" + md5Password + ", salt=" + salt
				+ ", permission=" + permission + ", role=" + role + ", state=" + state + "]";
	}

	
}
