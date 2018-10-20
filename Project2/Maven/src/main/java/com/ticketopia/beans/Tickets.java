package com.ticketopia.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tickets")
public class Tickets {
	@Id
	@Column(name="ticket_id")
	private Integer ticketId;
	
	@Column(name="ticket_type")
	private String ticketType;
	
	@ManyToOne
	@JoinColumn(name = "topic_id")
	private Topics topic;
	
	@ManyToOne
	@JoinColumn(name = "event_type_id")
	private EventTypes eventType;
	
	@Column(name="ticket_price")
	private Double ticketPrice;
	
	@Column(name="event_description")
	private String eventDescription;
	
	@Column(name="event_address")
	private String eventAddress;
	
	@Column(name="event_city")
	private String eventCity;
	
	@Column(name="event_state")
	private String eventState;
	
	@Column(name="event_zip")
	private Integer eventZip;
	
	@Column(name="seat")
	private String seat;
	
	@ManyToOne
	@JoinColumn(name = "partner_id")
	private Partners partner;

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public Topics getTopic() {
		return topic;
	}

	public void setTopic(Topics topic) {
		this.topic = topic;
	}

	public EventTypes getEventType() {
		return eventType;
	}

	public void setEventType(EventTypes eventType) {
		this.eventType = eventType;
	}

	public Double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(Double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getEventAddress() {
		return eventAddress;
	}

	public void setEventAddress(String eventAddress) {
		this.eventAddress = eventAddress;
	}

	public String getEventCity() {
		return eventCity;
	}

	public void setEventCity(String eventCity) {
		this.eventCity = eventCity;
	}

	public String getEventState() {
		return eventState;
	}

	public void setEventState(String eventState) {
		this.eventState = eventState;
	}

	public Integer getEventZip() {
		return eventZip;
	}

	public void setEventZip(Integer eventZip) {
		this.eventZip = eventZip;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public Partners getPartner() {
		return partner;
	}

	public void setPartner(Partners partner) {
		this.partner = partner;
	}

	@Override
	public String toString() {
		return "Tickets [ticketId=" + ticketId + ", ticketType=" + ticketType + ", topic=" + topic + ", eventType="
				+ eventType + ", ticketPrice=" + ticketPrice + ", eventDescription=" + eventDescription
				+ ", eventAddress=" + eventAddress + ", eventCity=" + eventCity + ", eventState=" + eventState
				+ ", eventZip=" + eventZip + ", seat=" + seat + ", partner=" + partner + "]";
	}

	public Tickets(Integer ticketId, String ticketType, Topics topic, EventTypes eventType, Double ticketPrice,
			String eventDescription, String eventAddress, String eventCity, String eventState, Integer eventZip,
			String seat, Partners partner) {
		super();
		this.ticketId = ticketId;
		this.ticketType = ticketType;
		this.topic = topic;
		this.eventType = eventType;
		this.ticketPrice = ticketPrice;
		this.eventDescription = eventDescription;
		this.eventAddress = eventAddress;
		this.eventCity = eventCity;
		this.eventState = eventState;
		this.eventZip = eventZip;
		this.seat = seat;
		this.partner = partner;
	}

	public Tickets(String ticketType, Topics topic, EventTypes eventType, Double ticketPrice, String eventDescription,
			String eventAddress, String eventCity, String eventState, Integer eventZip, String seat, Partners partner) {
		super();
		this.ticketType = ticketType;
		this.topic = topic;
		this.eventType = eventType;
		this.ticketPrice = ticketPrice;
		this.eventDescription = eventDescription;
		this.eventAddress = eventAddress;
		this.eventCity = eventCity;
		this.eventState = eventState;
		this.eventZip = eventZip;
		this.seat = seat;
		this.partner = partner;
	}

	public Tickets() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
