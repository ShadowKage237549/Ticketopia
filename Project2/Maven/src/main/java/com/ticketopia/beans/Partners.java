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
public class Partners {
	@Id
	@Column(name="partner_id")
	@SequenceGenerator(sequenceName="Partner_Generator", name="Partner_Id")
	@GeneratedValue(generator="Partner_Seq", strategy=GenerationType.SEQUENCE)
	private Integer partnerId;
	
	@Column(name="partner_name")
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