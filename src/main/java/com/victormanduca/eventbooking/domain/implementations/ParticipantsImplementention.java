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
		participant.setId(null);
		participantsRepository.save(participant);
	}

	public List<Participants> getMany() {
		return participantsRepository.findAll();
	}

	public Optional<Participants> getById(Integer id) {
		final Long idL = Long.valueOf(id);
		return participantsRepository.findById(idL);
	}

	public void updateById(Integer id, Participants participant) {
		participant.setId(id);
		participantsRepository.save(participant);
	}

	public void deleteById(Integer id) {
		final Long idL = Long.valueOf(id);
		participantsRepository.deleteById(idL);
	}
}
