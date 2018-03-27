package org.tysf.admin.domain;
//后台登录管理员账号
public class Admin {
	private int adminId;
	private String adminName;
	private int adminPwd;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(int adminId, String adminName, int adminPwd) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPwd = adminPwd;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public int getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(int adminPwd) {
		this.adminPwd = adminPwd;
	}
	@Override
	public String toString() {
		return "Admim [adminId=" + adminId + ", adminName=" + adminName + ", adminPwd=" + adminPwd + "]";
	}
	
}
