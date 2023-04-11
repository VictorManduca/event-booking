package com.victormanduca.eventbooking.domain.usecases;

import java.util.List;
import java.util.Optional;

import com.victormanduca.eventbooking.domain.entities.Participants;

public interface IParticipants {
	void CreateParticipant(Participants participant);
	List<Participants> GetParticipants();
	Optional<Participants> GetParticipant(Integer id);
	void UpdateParticipant(Participants participant, Integer id);
	void DeleteParticipant(Integer id);
}
