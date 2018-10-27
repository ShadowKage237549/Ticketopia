package com.ticketopia.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="partners")
public class Partner {
	@Id
	@Column(name="partner_id")
	@SequenceGenerator(sequenceName="Partner_Generator", name="Partner_Id")
	@GeneratedValue(generator="Partner_Id", strategy=GenerationType.SEQUENCE)
	private Integer partnerId;
	@Column(name="partner_description")
	private String partnerDesc;
	@Column(name="partner_name")
	private String partnerName;
	public Integer getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}
	public String getPartnerDesc() {
		return partnerDesc;
	}
	public void setPartnerDesc(String partnerDesc) {
		this.partnerDesc = partnerDesc;
	}
	public String getPartnerName() {
		return partnerName;
	}
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}
	@Override
	public String toString() {
		return "Partner [partnerId=" + partnerId + ", partnerDesc=" + partnerDesc + ", partnerName=" + partnerName
				+ "]";
	}
	public Partner(Integer partnerId, String partnerDesc, String partnerName) {
		super();
		this.partnerId = partnerId;
		this.partnerDesc = partnerDesc;
		this.partnerName = partnerName;
	}
	public Partner() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
