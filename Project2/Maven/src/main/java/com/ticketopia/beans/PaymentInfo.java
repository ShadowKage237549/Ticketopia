package com.ticketopia.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment_info")
public class PaymentInfo {
	@Id
	@Column(name="customer_email")
	private String userEmail;
	
	@Column(name="card_number")
	private Integer cardNumber;
	
	@Column(name="security_number")
	private Integer securityCode;
	
	@Column(name="expiration_date")
	private String expirationDate;
	
	@Column(name="billing_address")
	private String billingAddress;
	
	@Column(name="billing_city")
	private String billingCity;
	
	@Column(name="billing_state")
	private String billingState;
	
	@Column(name="billing_zip")
	private Integer billingZip;
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Integer getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Integer getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(Integer securityCode) {
		this.securityCode = securityCode;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	public String getBillingCity() {
		return billingCity;
	}
	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}
	public String getBillingState() {
		return billingState;
	}
	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}
	public Integer getBillingZip() {
		return billingZip;
	}
	public void setBillingZip(Integer billingZip) {
		this.billingZip = billingZip;
	}
	@Override
	public String toString() {
		return "PaymentInfo [userEmail=" + userEmail + ", cardNumber=" + cardNumber + ", securityCode=" + securityCode
				+ ", expirationDate=" + expirationDate + ", billingAddress=" + billingAddress + ", billingCity="
				+ billingCity + ", billingState=" + billingState + ", billingZip=" + billingZip + "]";
	}
	public PaymentInfo(String userEmail, Integer cardNumber, Integer securityCode, String expirationDate,
			String billingAddress, String billingCity, String billingState, Integer billingZip) {
		super();
		this.userEmail = userEmail;
		this.cardNumber = cardNumber;
		this.securityCode = securityCode;
		this.expirationDate = expirationDate;
		this.billingAddress = billingAddress;
		this.billingCity = billingCity;
		this.billingState = billingState;
		this.billingZip = billingZip;
	}
	public PaymentInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
