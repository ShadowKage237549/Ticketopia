package com.ticketopia.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity //Marks the class as a persistent class
@Table(name="user_type")
public class UserRole {
	@Id //Marks as a primary key
	@Column(name="role_id")
	private Integer roleId;
	
	@Column(name="role_name")
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
	public UserRole(Integer roleId, String role) {
		super();
		this.roleId = roleId;
		this.role = role;
	}
<<<<<<< HEAD:Project2/Maven/src/main/java/com/ticketopia/beans/UserRole.java
	public UserRole(String role) {
		super();
		this.role = role;
	}
	public UserRole() {
=======
	public UserRoles() {
>>>>>>> b2582ba956cc61d72f80d104f0b8e7c172b0c92f:Project2/Maven/src/main/java/com/ticketopia/beans/UserRoles.java
		super();
		// TODO Auto-generated constructor stub
	}
	
}