package com.victormanduca.eventbooking.domain.implementations;

import java.util.List;
import java.util.Optional;

import com.victormanduca.eventbooking.domain.entities.Participants;
import com.victormanduca.eventbooking.domain.usecases.IParticipants;
import com.victormanduca.eventbooking.infra.repositories.IParticipantsRepository;

public class ParticipantsImplementention implements IParticipants {
	private IParticipantsRepository participantsRepository;

	public ParticipantsImplementention(IParticipantsRepository repository) {
		this.participantsRepository = repository;
	}

	public void create(Participants participant) {
		participantsRepository.save(participant);
	}

	public List<Participants> getMany() {
		return participantsRepository.findAll();
	}

	public Optional<Participants> getById(int id) {
		return participantsRepository.findById(id);
	}

	public void updateById(int id, Participants participant) {
		participant.setId(id);
		participantsRepository.save(participant);
	}

	public void deleteById(int id) {
		participantsRepository.deleteById(id);
	}
}
