package com.victormanduca.eventbooking.domain.entities;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "The name of the event is mandatory")
	private String name;

	@Column(name = "max_participants")
	private int maxParticipants;

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	public Event() {
	}

	public Event(int id, Address address, String name, int maxParticipants) {
		super();
		this.id = id;
		this.address = address;
		this.name = name;
		this.maxParticipants = maxParticipants;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", maxParticipants=" + maxParticipants + ", address=" + address
				+ "]";
	}
}
