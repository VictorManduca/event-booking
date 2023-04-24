package com.victormanduca.eventbooking.domain.entities.dtos;

import java.io.Serializable;

public class EventDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private int maxParticipants;
	private int addressId;

	public EventDTO() {
	}

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
