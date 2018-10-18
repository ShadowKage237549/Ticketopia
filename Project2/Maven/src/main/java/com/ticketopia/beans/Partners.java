package com.ticketopia.beans;

public class Partners {
	private Integer partnerId;
	private String partnerName;
	public Integer getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}
	public String getPartnerName() {
		return partnerName;
	}
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}
	@Override
	public String toString() {
		return "Partners [partnerId=" + partnerId + ", partnerName=" + partnerName + "]";
	}
	public Partners(Integer partnerId, String partnerName) {
		super();
		this.partnerId = partnerId;
		this.partnerName = partnerName;
	}
	public Partners(String partnerName) {
		super();
		this.partnerName = partnerName;
	}
	public Partners() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
