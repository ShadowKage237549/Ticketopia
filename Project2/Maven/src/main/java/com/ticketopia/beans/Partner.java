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
	@SequenceGenerator(sequenceName="Partner_Seq", name="Partner_Seq")
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
	public Partner(Integer partnerId, String partnerName) {
		super();
		this.partnerId = partnerId;
		this.partnerName = partnerName;
	}
<<<<<<< HEAD:Project2/Maven/src/main/java/com/ticketopia/beans/Partner.java
	public Partner(String partnerName) {
		super();
		this.partnerName = partnerName;
	}
	public Partner() {
=======
	public Partners() {
>>>>>>> b2582ba956cc61d72f80d104f0b8e7c172b0c92f:Project2/Maven/src/main/java/com/ticketopia/beans/Partners.java
		super();
		// TODO Auto-generated constructor stub
	}
	
}
