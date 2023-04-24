package com.victormanduca.eventbooking.domain.entities.dtos;

public class EventDTO {

	private String name;
	private int maxParticipants;
	private int addressId;

	public EventDTO(String name, int maxParticipants, int addressId) {
		super();
		this.name = name;
		this.maxParticipants = maxParticipants;
		this.addressId = addressId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxParticipants() {
		return maxParticipants;
	}

	public void setMaxParticipants(int maxParticipants) {
		this.maxParticipants = maxParticipants;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

}
