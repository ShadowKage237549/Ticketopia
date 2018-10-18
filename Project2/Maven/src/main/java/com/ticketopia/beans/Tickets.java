package com.ticketopia.beans;

public class Tickets {
	private Integer ticketId;
	private String ticketType;
	private Integer topicId;
	private Integer eventTypeId;
	private Integer ticketPrice;
	private String eventDescription;
	private String eventAddress;
	private String eventCity;
	private String eventState;
	private Integer eventZip;
	private String seat;
	private Integer partnerId;
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
	public Integer getTopicId() {
		return topicId;
	}
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}
	public Integer getEventTypeId() {
		return eventTypeId;
	}
	public void setEventTypeId(Integer eventTypeId) {
		this.eventTypeId = eventTypeId;
	}
	public Integer getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(Integer ticketPrice) {
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
	public Integer getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}
	@Override
	public String toString() {
		return "Tickets [ticketId=" + ticketId + ", ticketType=" + ticketType + ", topicId=" + topicId
				+ ", eventTypeId=" + eventTypeId + ", ticketPrice=" + ticketPrice + ", eventDescription="
				+ eventDescription + ", eventAddress=" + eventAddress + ", eventCity=" + eventCity + ", eventState="
				+ eventState + ", eventZip=" + eventZip + ", seat=" + seat + ", partnerId=" + partnerId + "]";
	}
	public Tickets(Integer ticketId, String ticketType, Integer topicId, Integer eventTypeId, Integer ticketPrice,
			String eventDescription, String eventAddress, String eventCity, String eventState, Integer eventZip,
			String seat, Integer partnerId) {
		super();
		this.ticketId = ticketId;
		this.ticketType = ticketType;
		this.topicId = topicId;
		this.eventTypeId = eventTypeId;
		this.ticketPrice = ticketPrice;
		this.eventDescription = eventDescription;
		this.eventAddress = eventAddress;
		this.eventCity = eventCity;
		this.eventState = eventState;
		this.eventZip = eventZip;
		this.seat = seat;
		this.partnerId = partnerId;
	}
	public Tickets(String ticketType, Integer topicId, Integer eventTypeId, Integer ticketPrice,
			String eventDescription, String eventAddress, String eventCity, String eventState, Integer eventZip,
			String seat, Integer partnerId) {
		super();
		this.ticketType = ticketType;
		this.topicId = topicId;
		this.eventTypeId = eventTypeId;
		this.ticketPrice = ticketPrice;
		this.eventDescription = eventDescription;
		this.eventAddress = eventAddress;
		this.eventCity = eventCity;
		this.eventState = eventState;
		this.eventZip = eventZip;
		this.seat = seat;
		this.partnerId = partnerId;
	}
	public Tickets() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
