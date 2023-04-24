package com.victormanduca.eventbooking.domain.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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

	@JsonIgnoreProperties("participantEvents")
	@ManyToMany(mappedBy = "participantEvents")
	private Set<Participants> participants;

	public Event() {
	}

	public Event(int id, String name, int maxParticipants, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.maxParticipants = maxParticipants;
		this.address = address;
	}

	public Event(int id, String name, int maxParticipants, Address address, Set<Participants> participants) {
		super();
		this.id = id;
		this.name = name;
		this.maxParticipants = maxParticipants;
		this.address = address;
		this.participants = participants;
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

	public Set<Participants> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<Participants> participants) {
		this.participants = participants;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, name, participants);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		return Objects.equals(address, other.address) && Objects.equals(name, other.name)
				&& Objects.equals(participants, other.participants);
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", maxParticipants=" + maxParticipants + ", address=" + address
				+ "]";
	}
}
