package com.ticketopia.beans;

public class PaymentInfo {
	private String userEmail;
	private Integer cardNumber;
	private Integer securityCode;
	private String expirationDate;
	private String billingAddress;
	private String billingCity;
	private String billingState;
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
