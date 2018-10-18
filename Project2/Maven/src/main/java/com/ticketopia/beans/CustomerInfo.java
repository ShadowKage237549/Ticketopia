package com.ticketopia.beans;

public class CustomerInfo {
	private String userEmail;
	private String displayName;
	private String userFName;
	private String userLName;
	private Integer accumulatedPoints;
	private Integer role;
	private String userAddress;
	private String password;
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getUserFName() {
		return userFName;
	}
	public void setUserFName(String userFName) {
		this.userFName = userFName;
	}
	public String getUserLName() {
		return userLName;
	}
	public void setUserLName(String userLName) {
		this.userLName = userLName;
	}
	public Integer getAccumulatedPoints() {
		return accumulatedPoints;
	}
	public void setAccumulatedPoints(Integer accumulatedPoints) {
		this.accumulatedPoints = accumulatedPoints;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "CustomerInfo [userEmail=" + userEmail + ", displayName=" + displayName + ", userFName=" + userFName
				+ ", userLName=" + userLName + ", accumulatedPoints=" + accumulatedPoints + ", role=" + role
				+ ", userAddress=" + userAddress + ", password=" + password + "]";
	}
	public CustomerInfo(String userEmail, String displayName, String userFName, String userLName,
			Integer accumulatedPoints, Integer role, String userAddress, String password) {
		super();
		this.userEmail = userEmail;
		this.displayName = displayName;
		this.userFName = userFName;
		this.userLName = userLName;
		this.accumulatedPoints = accumulatedPoints;
		this.role = role;
		this.userAddress = userAddress;
		this.password = password;
	}
	public CustomerInfo(String displayName, String userFName, String userLName, Integer accumulatedPoints, Integer role,
			String userAddress, String password) {
		super();
		this.displayName = displayName;
		this.userFName = userFName;
		this.userLName = userLName;
		this.accumulatedPoints = accumulatedPoints;
		this.role = role;
		this.userAddress = userAddress;
		this.password = password;
	}
	public CustomerInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
