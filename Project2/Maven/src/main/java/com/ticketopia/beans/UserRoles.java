package com.ticketopia.beans;

public class UserRoles {
	private Integer roleId;
	private String role;
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserRoles [roleId=" + roleId + ", role=" + role + "]";
	}
	public UserRoles(Integer roleId, String role) {
		super();
		this.roleId = roleId;
		this.role = role;
	}
	public UserRoles(String role) {
		super();
		this.role = role;
	}
	public UserRoles() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
