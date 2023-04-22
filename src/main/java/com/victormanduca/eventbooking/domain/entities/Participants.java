package com.victormanduca.eventbooking.domain.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Participants implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "Name is mandatory")
	private String name;

	private String document;

	@JsonIgnoreProperties("participants")
	@ManyToMany
	@JoinTable(name = "participant_events", joinColumns = @JoinColumn(name = "participants_id"), inverseJoinColumns = @JoinColumn(name = "event_id"))
	private Set<Event> participantEvents;

	public Participants() {
	}

	Participants(int id, String name, String document, Set<Event> participantOfEvents) {
		super();
		this.id = id;
		this.name = name;
		this.document = document;
		this.participantEvents = participantOfEvents;
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

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public Set<Event> getParticipantEvents() {
		return participantEvents;
	}

	public void setParticipantEvents(Set<Event> participantOfEvents) {
		this.participantEvents = participantOfEvents;
	}

	@Override
	public int hashCode() {
		return Objects.hash(document, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participants other = (Participants) obj;
		return Objects.equals(document, other.document);
	}
}
