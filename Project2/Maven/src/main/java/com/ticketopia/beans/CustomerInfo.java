package com.ticketopia.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity //Marks the class as a persistent class
@Table(name="customer_information",schema = "orcl")
public class CustomerInfo {
	@Id //Marks as a primary key
	@Column(name="customer_email")
	@SequenceGenerator(sequenceName="ci_seq", name="ci_seq")
	@GeneratedValue(generator="ci_seq", strategy=GenerationType.SEQUENCE)
	private String userEmail;
	
	@Column(name="display_name")
	private String displayName;
	
	@Column(name="user_fname")
	private String userFName;
	
	@Column(name="user_lname")
	private String userLName;
	
	@Column(name="accumulated_points") 
	private Integer accumulatedPoints;
	
	@Column(name = "user_type")
	private Integer role;
	
	@Column(name="customer_address")
	private String userAddress;
	
	@Column(name="customer_city")
	private String userCity;
	
	@Column(name="customer_state")
	private String userState;
	
	@Column(name="customer_zip")
	private Integer userZip;
	
	@Column(name="customer_password")
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

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public Integer getUserZip() {
		return userZip;
	}

	public void setUserZip(Integer userZip) {
		this.userZip = userZip;
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
				+ ", userAddress=" + userAddress + ", userCity=" + userCity + ", userState=" + userState + ", userZip="
				+ userZip + ", password=" + password + "]";
	}

	public CustomerInfo(String userEmail, String displayName, String userFName, String userLName,
			Integer accumulatedPoints, Integer role, String userAddress, String userCity, String userState,
			Integer userZip, String password) {
		super();
		this.userEmail = userEmail;
		this.displayName = displayName;
		this.userFName = userFName;
		this.userLName = userLName;
		this.accumulatedPoints = accumulatedPoints;
		this.role = role;
		this.userAddress = userAddress;
		this.userCity = userCity;
		this.userState = userState;
		this.userZip = userZip;
		this.password = password;
	}

	public CustomerInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
